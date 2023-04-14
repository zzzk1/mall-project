package com.example.mallproject.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.Annotation.PermissionRequired;
import com.example.mallproject.common.api.Logical;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.api.UserType;
import com.example.mallproject.common.api.WebConstant;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.entity.User;
import com.example.mallproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    HttpSession session;

    @PostMapping("/login")
    public Result<User> login(@RequestBody User user) {
        ValidatorUtils.checkNull(user, "user");
        ValidatorUtils.checkNull(user.getName(), "username");
        ValidatorUtils.checkNull(user.getPassword(), "password");

        User loginUser = userService.login(user);
        if (loginUser == null) {
            return Result.Failed(null, "密码错误或用户名错误");
        }
        session.setAttribute(WebConstant.CURRENT_USER_IN_SESSION, user);

        return Result.Success(loginUser, "登录成功");
    }

    @PostMapping("/register")
    public Result<Boolean> enroll(@RequestBody User user) {
        ValidatorUtils.checkNull(user, "user");
        ValidatorUtils.checkNull(user.getName(), "username");
        ValidatorUtils.checkNull(user.getPassword(), "password");

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", user.getName());

        if (userService.getOne(userQueryWrapper) != null) {
            return Result.Failed( false,"用户名已存在");
        }
        userService.enroll(user);
        session.setAttribute("user", user);
        return Result.Success(true, "注册成功");
    }

    @PermissionRequired(userType = {UserType.ADMIN,UserType.TEACHER}, logical = Logical.OR)
    @GetMapping("/needPermission")
    public Result<String> needPermission() {
        return Result.Success(null, "if you see this, you has the permission.");
    }
}
