package com.example.mallproject.common.Exception;

import com.example.mallproject.common.api.ResultCode;
import lombok.Getter;

/**
 * @author zzzk1
 */
@Getter
public class BizException extends RuntimeException{
    private ResultCode error;

    public BizException(ResultCode error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    public BizException(ResultCode error) {
        this.error = error;
    }


}
