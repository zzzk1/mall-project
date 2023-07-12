package com.system.design.controller;


import com.system.design.common.api.Result;
import com.system.design.log.annotation.LogRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-11
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @LogRecord(context = "更新了地址," + "旧地址从{{#oldAddress}}更新为{{#newAddress}}", bizNo = "订单", operatorType = "更新")
    @PostMapping("edit")
    public Result<String> changeAddr(@RequestParam String oldAddress, @RequestParam String newAddress) {

        return Result.success(null);
    }
}
