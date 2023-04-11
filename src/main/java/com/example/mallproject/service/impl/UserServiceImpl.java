package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.mapper.UserMapper;
import com.example.mallproject.pojo.user;
import com.example.mallproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<user> getAll() {
        QueryWrapper<user> query = new QueryWrapper<user>();
        return userMapper.selectList(query);
    }

    @Override
    public user getById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public user getByName(String name) {
        QueryWrapper<user> query = new QueryWrapper<>();
        query.eq("name", name);
        user user = new user();
        user = userMapper.selectOne(query);
        return user;
    }

    @Override
    public int add(user user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteByName(String name) {
       QueryWrapper<user> query = new QueryWrapper<>();
       query.eq("name", name);
       return userMapper.delete(query);
    }

    @Override
    public int deleteNyId(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateByName(String name, user user) {
        QueryWrapper<com.example.mallproject.pojo.user> query = new QueryWrapper<>();
        query.eq("name", name);
        return userMapper.update(user, query);
    }

    @Override
    public int updateById(int id, user user) {
        QueryWrapper<com.example.mallproject.pojo.user> query = new QueryWrapper<>();
        query.eq("id", id);
        return userMapper.update(user, query);
    }
}
