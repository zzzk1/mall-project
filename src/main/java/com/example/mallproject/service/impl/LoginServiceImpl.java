package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.entity.User;
import com.example.mallproject.service.LoginService;
import com.example.mallproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;

    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", user.getName());
        queryWrapper.eq("password", user.getPassword());
        return userService.getOne(queryWrapper);
    }

    @Override
    public boolean enroll(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return userService.save(user);
    }
}
