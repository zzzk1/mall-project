package com.example.mallproject.controller;

import com.example.mallproject.common.api.Result;
import com.example.mallproject.pojo.User;
import com.example.mallproject.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Api(tags = "登录接口")
@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public Result<User> login(HttpSession session,@RequestBody User user) {
        Result<User> checkResult;
        checkResult = paramCheck(user);
        if (checkResult != null) {
            return checkResult;
        }
        Result<User> result = service.login(user);
        //登录成功
        if (!Objects.equals(result, Result.Failed(user))) {
            session.setAttribute("user", user);
        }
        return result;
    }

    @PostMapping("/register")
    public Result<User> register(@RequestBody User user) {
        Result<User> checkResult;
        checkResult = paramCheck(user);
        if (checkResult != null) {
            return checkResult;
        }
        return service.register(user);
    }

    //参数检验
    private Result<User> paramCheck(User user) {
        if (user == null) {
            return Result.Failed(user, "参数为空.");
        }
        else if (user.getName() == null) {
            return Result.Failed(user, "用户名为空");
        }
        else if (user.getPassword() == null) {
            return Result.Failed(user, "密码为空");
        }
        return null;
    }
}
