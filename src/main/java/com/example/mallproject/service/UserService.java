package com.example.mallproject.service;

import com.example.mallproject.pojo.DO.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(int id);
    User getByName(String name);
    int add(User user);
    int deleteByName(String name);
    int deleteById(int id);
    int updateByName(String name, User user);
    int updateById(int id, User user);
}
