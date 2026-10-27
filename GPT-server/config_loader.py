# -*- coding: utf-8 -*-
"""
工作内容：
  读取项目根目录下的 config.yaml，提供全局配置访问。
  负责校验关键 Key、用户列表、agent 列表等基础字段是否齐全。
"""

from __future__ import annotations

from pathlib import Path
from typing import Any

import yaml

# 本文件所在目录即 GPT-server 项目根
PROJECT_ROOT = Path(__file__).resolve().parent
CONFIG_PATH = PROJECT_ROOT / "config.yaml"

_config: dict[str, Any] | None = None


def load_config(force_reload: bool = False) -> dict[str, Any]:
    """加载（或返回缓存的）配置字典。"""
    global _config
    if _config is not None and not force_reload:
        return _config

    if not CONFIG_PATH.is_file():
        raise FileNotFoundError(f"找不到配置文件: {CONFIG_PATH}")

    with CONFIG_PATH.open("r", encoding="utf-8") as f:
        data = yaml.safe_load(f) or {}

    _validate(data)
    _config = data
    return _config


def _validate(data: dict[str, Any]) -> None:
    """做最小必要校验，避免启动后才发现关键漏配。"""
    openai_cfg = data.get("openai") or {}
    if not str(openai_cfg.get("api_key") or "").strip():
        # 允许启动，但调用出图时再报错，方便先改配置
        pass

    users = data.get("users")
    if not isinstance(users, list) or not users:
        raise ValueError("config.yaml 中 users 必须是非空列表")

    agents = data.get("agents")
    if not isinstance(agents, list) or not agents:
        raise ValueError("config.yaml 中 agents 必须是非空列表")

    for item in agents:
        if not item.get("id") or not item.get("model"):
            raise ValueError(f"agent 缺少 id 或 model: {item}")


def get_openai_api_key() -> str:
    key = str((load_config().get("openai") or {}).get("api_key") or "").strip()
    if not key:
        raise RuntimeError("config.yaml 中 openai.api_key 尚未填写")
    return key


def get_openai_base_url() -> str | None:
    url = str((load_config().get("openai") or {}).get("base_url") or "").strip()
    return url or None


def get_log_file_path() -> Path:
    rel = (load_config().get("logging") or {}).get("file") or "logs/call_records.txt"
    path = Path(rel)
    if not path.is_absolute():
        path = PROJECT_ROOT / path
    return path


def get_max_workers() -> int:
    raw = (load_config().get("concurrency") or {}).get("max_workers", 5)
    try:
        n = int(raw)
    except (TypeError, ValueError):
        n = 5
    return max(1, n)
