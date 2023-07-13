package com.system.design.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ErrorHandler;

/**
 * StreamPollTask 获取消息或对应的listener消费消息过程中发生了异常
 *
 * @author huan.fu 2021/11/11 - 下午3:44
 */
@Slf4j
public class CustomErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable t) {
        log.error("发生了异常", t);
    }
}
