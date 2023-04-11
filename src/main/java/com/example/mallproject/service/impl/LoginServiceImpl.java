package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.mapper.UserMapper;
import com.example.mallproject.pojo.User;
import com.example.mallproject.service.LoginService;
import com.example.mallproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Override
    public Result<User> login(User user) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("name", user.getName());
        query.eq("password", user.getPassword());

        if (userMapper.selectOne(query) == null) {
            return Result.Failed(user, "用户不存在或密码错误.");
        } else {
            return Result.Success(user);
        }
    }

    @Override
    public Result<User> register(User user) {
        if (userService.getByName(user.getName()) != null) {
            return Result.Failed(user, "用户已存在.");
        }

        userMapper.insert(user);
        return Result.Success(user);
    }
}
