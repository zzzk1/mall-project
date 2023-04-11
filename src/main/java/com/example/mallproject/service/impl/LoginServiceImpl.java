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
    public Result<User> login(String name, String password) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("name", name);
        query.eq("password", password);
        User user =  userMapper.selectOne(query);
        if (user == null) {
            return null;
        } else {
            return Result.Success(user);
        }
    }

    @Override
    public Result<User> register(String name, String password) {
            User user = userService.getByName(name);
            if (user != null) {
                return Result.Failed(user);
            }
            user.setName(name);
            user.setPassword(password);
            userMapper.insert(user);
            return Result.Success(user);
    }
}
