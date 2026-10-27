# -*- coding: utf-8 -*-
"""
工作内容：
  基于 config.yaml 中配死的 users 列表做简易账号密码校验。
  仅适合内网短期服务，不做哈希、不做会话。
"""

from __future__ import annotations

from config_loader import load_config


def verify_user(account: str, password: str) -> bool:
    """
    校验账号密码是否匹配配置中的某一项。
    两边都按字符串精确比较（去首尾空白后）。
    """
    account = (account or "").strip()
    password = password or ""

    if not account:
        return False

    for user in load_config().get("users") or []:
        cfg_account = str(user.get("account") or "").strip()
        cfg_password = str(user.get("password") or "")
        if cfg_account == account and cfg_password == password:
            return True
    return False
