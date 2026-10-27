# -*- coding: utf-8 -*-
"""
工作内容：
  FastAPI 入口。对外暴露：
    GET  /health     — 探活，无参数
    GET  /agents     — 列出已注册（存活）agent，无需鉴权
    POST /query_GPT  — 验账号密码 + agent_id，调用 images.generate，原样返回上游结果并写 txt 日志
  出图任务经最多 5 线程的线程池执行，避免打满上游。
"""

from __future__ import annotations

import asyncio
from typing import Any

from fastapi import FastAPI, HTTPException
from pydantic import BaseModel, Field

from agent_registry import get_agent, list_agents
from auth import verify_user
from call_logger import append_call_log
from concurrency import get_executor
from image_service import generate_image

app = FastAPI(
    title="GPT-server",
    description="内网轻量出图转发：配置化 agent + images.generate",
    version="0.1.0",
)


class QueryGPTRequest(BaseModel):
    """/query_GPT 请求体。"""

    account: str = Field(..., description="配置中的调用人账号")
    password: str = Field(..., description="配置中的口令")
    agent_id: str = Field(..., description="已注册 agent 的 id")
    ask_content: str = Field(..., description="文生图提示词（prompt）")


@app.get("/health")
def health() -> dict[str, str]:
    """探活：进程在即返回 ok，不探测上游。"""
    return {"status": "ok"}


@app.get("/agents")
def agents() -> dict[str, Any]:
    """返回当前配置中全部已注册 agent（本地视为存活）。"""
    items = list_agents()
    return {"count": len(items), "agents": items}


@app.post("/query_GPT")
async def query_gpt(body: QueryGPTRequest) -> dict[str, Any]:
    """
    1. 校验账号密码
    2. 校验 agent_id
    3. 在线程池中调用 images.generate
    4. 写调用日志（不含返回体）
    5. 原样返回上游响应 dict
    """
    if not verify_user(body.account, body.password):
        raise HTTPException(status_code=401, detail="账号或密码错误")

    agent = get_agent(body.agent_id)
    if agent is None:
        raise HTTPException(status_code=404, detail=f"未知 agent_id: {body.agent_id}")

    prompt = (body.ask_content or "").strip()
    if not prompt:
        raise HTTPException(status_code=400, detail="ask_content 不能为空")

    agent_name = str(agent.get("name") or agent.get("id") or "")
    model = str(agent.get("model") or "")

    loop = asyncio.get_running_loop()
    try:
        # 在最多 5 线程的池中执行同步 SDK 调用，避免阻塞事件循环
        upstream: dict[str, Any] = await loop.run_in_executor(
            get_executor(),
            generate_image,
            agent,
            prompt,
        )
    except Exception as exc:  # noqa: BLE001 — 上游/配置错误统一转给调用方
        append_call_log(
            account=body.account,
            agent_id=body.agent_id,
            agent_name=agent_name,
            model=model,
            ask_content=prompt,
            upstream=None,
            note=f"error:{type(exc).__name__}",
        )
        raise HTTPException(status_code=502, detail=f"出图失败: {exc}") from exc

    append_call_log(
        account=body.account,
        agent_id=body.agent_id,
        agent_name=agent_name,
        model=model,
        ask_content=prompt,
        upstream=upstream,
    )
    return upstream


if __name__ == "__main__":
    # 本地直接运行：python main.py
    import uvicorn

    uvicorn.run("main:app", host="0.0.0.0", port=8000, reload=False)
