package com.cooler.biz.auth.exception;

import com.cooler.biz.base.exception.ServiceException;

/**
 * 认证异常
 *
 */
public class AuthException extends ServiceException {
    public AuthException() {
        super("Authentication failed", 403);
    }
}
