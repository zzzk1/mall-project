package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.mapper.UserMapper;
import com.example.mallproject.pojo.User;
import com.example.mallproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        QueryWrapper<User> query = new QueryWrapper<User>();
        return userMapper.selectList(query);
    }

    @Override
    public User getById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getByName(String name) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("name", name);
        User user = new User();
        user = userMapper.selectOne(query);
        return user;
    }

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteByName(String name) {
       QueryWrapper<User> query = new QueryWrapper<>();
       query.eq("name", name);
       return userMapper.delete(query);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateByName(String name, User user) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("name", name);
        return userMapper.update(user, query);
    }

    @Override
    public int updateById(int id, User user) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("id", id);
        return userMapper.update(user, query);
    }
}
