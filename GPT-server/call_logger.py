# -*- coding: utf-8 -*-
"""
工作内容：
  将每次 /query_GPT 调用写入项目下 txt 日志。
  只记录调用人、agent、请求内容与用量字段；不记录接口返回体（尤其不写 base64）。
"""

from __future__ import annotations

import threading
from datetime import datetime, timezone, timedelta
from typing import Any

from config_loader import get_log_file_path

# 日志时区：按团队常用的东八区落盘，便于人工查阅
_TZ_SHANGHAI = timezone(timedelta(hours=8))

# 多线程写同一文件时加锁，避免行交错
_lock = threading.Lock()

# 表头：固定列，缺省留空
_HEADER = (
    "time\taccount\tagent_id\tagent_name\tmodel\task_content\t"
    "total_tokens\tinput_tokens\toutput_tokens\tnote\n"
)


def _ensure_file() -> None:
    path = get_log_file_path()
    path.parent.mkdir(parents=True, exist_ok=True)
    if not path.exists():
        path.write_text(_HEADER, encoding="utf-8")


def _safe_cell(value: Any) -> str:
    """表格单元格：去掉换行，避免一行被拆开。"""
    text = "" if value is None else str(value)
    return text.replace("\t", " ").replace("\r", " ").replace("\n", "\\n")


def extract_usage_fields(upstream: dict[str, Any] | None) -> dict[str, str]:
    """
    从 images.generate 响应中尽量抽取用量字段。
    dall-e-2/3 通常无 usage；GPT Image 系列可能带 usage。
    没有则返回空字符串，保持列对齐。
    """
    empty = {"total_tokens": "", "input_tokens": "", "output_tokens": "", "note": ""}
    if not upstream or not isinstance(upstream, dict):
        empty["note"] = "no_usage"
        return empty

    usage = upstream.get("usage")
    if not isinstance(usage, dict):
        empty["note"] = "no_usage_field"
        return empty

    def pick(*keys: str) -> str:
        for k in keys:
            if usage.get(k) is not None:
                return str(usage.get(k))
        return ""

    return {
        "total_tokens": pick("total_tokens"),
        "input_tokens": pick("input_tokens", "prompt_tokens"),
        "output_tokens": pick("output_tokens", "completion_tokens"),
        "note": "",
    }


def append_call_log(
    *,
    account: str,
    agent_id: str,
    agent_name: str,
    model: str,
    ask_content: str,
    upstream: dict[str, Any] | None = None,
    note: str = "",
) -> None:
    """追加一行调用记录（不写返回图片内容）。"""
    usage = extract_usage_fields(upstream)
    if note:
        usage["note"] = note if not usage["note"] else f"{usage['note']};{note}"

    now = datetime.now(_TZ_SHANGHAI).strftime("%Y-%m-%d %H:%M:%S %z")
    line = "\t".join(
        [
            _safe_cell(now),
            _safe_cell(account),
            _safe_cell(agent_id),
            _safe_cell(agent_name),
            _safe_cell(model),
            _safe_cell(ask_content),
            _safe_cell(usage["total_tokens"]),
            _safe_cell(usage["input_tokens"]),
            _safe_cell(usage["output_tokens"]),
            _safe_cell(usage["note"]),
        ]
    ) + "\n"

    with _lock:
        _ensure_file()
        with get_log_file_path().open("a", encoding="utf-8") as f:
            f.write(line)
