package com.system.design.common.api;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zzzk1
 */

@Getter
public enum Code {
    Success(200, "操作成功"),
    Failed(500, "操作失败");
    private final Integer code;
    private final String message;

    private Code(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
