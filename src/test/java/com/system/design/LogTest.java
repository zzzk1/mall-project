package com.system.design;

import com.system.design.common.api.Result;
import com.system.design.log.annotation.LogRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class LogTest {

    @Test
    void logTest() {
        logDTOTest();
    }

    @LogRecord(context = "注解测试", bizNo = "注解", operatorType = "测试")
    private Result<String> logDTOTest() {
        return Result.success("操作成功");
    }
}
