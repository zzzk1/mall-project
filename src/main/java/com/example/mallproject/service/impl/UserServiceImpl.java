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
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getUserByName(String name) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("name", name);
        User user = new User();
        user = userMapper.selectOne(query);
        return user;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUserByName(String name) {
       QueryWrapper<User> query = new QueryWrapper<>();
       query.eq("name", name);
       return userMapper.delete(query);
    }

    @Override
    public int deleteUserNyId(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUserByName(String name, User user) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("name", name);
        return userMapper.update(user, query);
    }

    @Override
    public int updateUserById(int id, User user) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("id", id);
        return userMapper.update(user, query);
    }
}
