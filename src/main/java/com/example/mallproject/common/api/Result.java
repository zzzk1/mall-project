package com.example.mallproject.common.api;

import lombok.Data;

@Data
public class Result<T> {
    private long code;
    private String message;
    private T data;

    protected Result(){};

    public Result(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static<T> Result<T> Success(T data, String message) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static<T> Result<T> Failed(T data) {
        return new Result<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), data);
    }

    public static<T> Result<T> Failed(T data, String message) {
        return new Result<T>(ResultCode.FAILED.getCode(), message, data);
    }
}
