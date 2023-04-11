package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.mapper.UserMapper;
import com.example.mallproject.pojo.User;
import com.example.mallproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String name, String password) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("name", name);
        query.eq("password", password);
        return userMapper.selectOne(query);
    }

    @Override
    public User register(String name, String password) {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            userMapper.insert(user);
            return user;
    }
}
