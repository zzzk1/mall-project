package com.system.design.controller;


import com.system.design.common.api.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-05
 */
@RestController
@RequestMapping("/log")
public class UserController {
    @GetMapping(value = "/test")
    public Result<String> selectPage(@RequestParam(value = "userId")Integer userId,
                             @RequestParam(value = "index")Integer index,
                             @RequestParam(value = "size")Integer size){
        return Result.success("操作成功");
    }
}
