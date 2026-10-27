# -*- coding: utf-8 -*-
"""
工作内容：
  管理配置中注册的出图 agent（id / 名称 / 模型 / 默认参数）。
  不依赖 openai-agents SDK；此处「agent」仅为路由配置条目。
"""

from __future__ import annotations

from typing import Any

from config_loader import load_config


def list_agents() -> list[dict[str, Any]]:
    """
    返回当前进程已加载的全部 agent 摘要（视为「存活」）。
    不探测上游 OpenAI，避免列表接口消耗额度。
    """
    result: list[dict[str, Any]] = []
    for item in load_config().get("agents") or []:
        result.append(
            {
                "id": item.get("id"),
                "name": item.get("name") or item.get("id"),
                "model": item.get("model"),
                "defaults": dict(item.get("defaults") or {}),
                "alive": True,
            }
        )
    return result


def get_agent(agent_id: str) -> dict[str, Any] | None:
    """按 id 查找单个 agent 配置；找不到返回 None。"""
    agent_id = (agent_id or "").strip()
    if not agent_id:
        return None
    for item in load_config().get("agents") or []:
        if str(item.get("id") or "").strip() == agent_id:
            return item
    return None
