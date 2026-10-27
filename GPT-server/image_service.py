# -*- coding: utf-8 -*-
"""
工作内容：
  封装 OpenAI images.generate 调用。
  按 agent 配置里的 model + defaults 发请求，将上游响应转为可 JSON 序列化的 dict 原样返回。
"""

from __future__ import annotations

from typing import Any

from openai import OpenAI

from config_loader import get_openai_api_key, get_openai_base_url

# GPT Image 系列不支持 response_format=url，调用时需剥离该参数
_GPT_IMAGE_PREFIXES = ("gpt-image", "chatgpt-image")


def _is_gpt_image_model(model: str) -> bool:
    m = (model or "").lower()
    return any(m.startswith(p) for p in _GPT_IMAGE_PREFIXES)


def _build_client() -> OpenAI:
    kwargs: dict[str, Any] = {"api_key": get_openai_api_key()}
    base_url = get_openai_base_url()
    if base_url:
        kwargs["base_url"] = base_url
    return OpenAI(**kwargs)


def generate_image(agent: dict[str, Any], prompt: str) -> dict[str, Any]:
    """
    使用指定 agent 配置生成图片。

    返回值：尽量接近上游 Images 响应的 dict（含 data / created / usage 等，有则带上）。
    """
    model = str(agent.get("model") or "").strip()
    if not model:
        raise ValueError("agent 未配置 model")

    params: dict[str, Any] = dict(agent.get("defaults") or {})
    params["model"] = model
    params["prompt"] = prompt

    # dall-e 可用 url；GPT Image 强制走默认 b64，去掉无效的 response_format
    if _is_gpt_image_model(model):
        params.pop("response_format", None)

    client = _build_client()
    response = client.images.generate(**params)

    # SDK 对象 -> 普通 dict，便于 FastAPI 原样 JSON 返回
    if hasattr(response, "model_dump"):
        return response.model_dump()
    if hasattr(response, "to_dict"):
        return response.to_dict()
    return dict(response)  # type: ignore[arg-type]
