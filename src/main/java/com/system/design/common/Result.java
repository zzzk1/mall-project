package com.system.design.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result<T> implements Serializable {
    private T data;
    private Integer code;
    private String message;

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }



    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    public static <T> Result<T> failed(String message) {
        return new Result<>(400, message);
    }

    public static <T> Result<T> failed() {
        return new Result<>(400, "操作失败");
    }
}
