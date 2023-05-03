package com.cooler.biz.user.exception;

import com.cooler.biz.base.exception.ServiceException;

public class PasswordErrorException extends ServiceException {
    public PasswordErrorException() {
        super(10400, "密码错误");
    }
}