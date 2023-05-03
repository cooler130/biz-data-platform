package com.cooler.biz.auth.exception;

import com.cooler.biz.base.exception.ServiceException;

public class UnauthorizedException extends ServiceException {
    public UnauthorizedException() {
        super("Unauthorized", 401);
    }
}
