package com.cooler.biz.user.exception;

import com.cooler.biz.base.exception.ServiceException;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException() {
        super(10404, "用户不存在");
    }
}