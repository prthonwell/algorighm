# -*- coding: utf-8 -*-
"""
工作内容：
  提供最多 N 个工作线程的线程池，限制同时进行的出图任务数量。
  默认 N=5，具体数值读自 config.yaml 的 concurrency.max_workers。
"""

from __future__ import annotations

import atexit
from concurrent.futures import ThreadPoolExecutor
from typing import Callable, TypeVar

from config_loader import get_max_workers

T = TypeVar("T")

_executor: ThreadPoolExecutor | None = None


def get_executor() -> ThreadPoolExecutor:
    """懒加载全局线程池，进程退出时关闭。"""
    global _executor
    if _executor is None:
        _executor = ThreadPoolExecutor(
            max_workers=get_max_workers(),
            thread_name_prefix="img-gen",
        )
        atexit.register(_shutdown)
    return _executor


def _shutdown() -> None:
    global _executor
    if _executor is not None:
        _executor.shutdown(wait=False, cancel_futures=False)
        _executor = None


def submit(fn: Callable[..., T], *args, **kwargs):
    """提交任务到出图线程池。"""
    return get_executor().submit(fn, *args, **kwargs)
