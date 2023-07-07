package com.system.design.controller;


import com.system.design.common.annotation.UserLog;
import com.system.design.common.api.ModuleEnum;
import com.system.design.common.api.OperationEnum;
import com.system.design.common.api.Result;
import com.system.design.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-07
 */
@RestController
@RequestMapping("/log")
@Slf4j

public class UserLogController {
    @UserLog(module = ModuleEnum.USER, title = "批量更新用户", type = OperationEnum.MODIFY)
    @PostMapping("/updateBatchUser")
    public Result<Boolean> updateBatchUser(@RequestBody List<User> userList) {
        return Result.success(null);
    }

    @UserLog(module = ModuleEnum.USER, title = "查询用户", type = OperationEnum.ADD)
    @GetMapping("/get")
    public Result<Boolean> insertUser() {
        return Result.success(null);
    }

}
