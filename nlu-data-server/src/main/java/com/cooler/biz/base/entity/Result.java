package com.cooler.biz.base.entity;

import lombok.Getter;

@Getter
public class Result {
    private int code;
    private String message;
    private Object data;

    private Result setResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public Result success() {
        return setResult(200, "Success", null);
    }

    public Result success(Object data) {
        return setResult(200, "Success", data);
    }



    public Result fail(int code, String message) {
        return setResult(code, message, null);
    }

    public Result fail(String message, Object data) {
        return setResult(400, message, data);
    }

    public Result fail(int code, String message, Object data) {
        return setResult(code, message, data);
    }



}