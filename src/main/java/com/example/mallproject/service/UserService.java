package com.example.mallproject.service;

import com.example.mallproject.pojo.user;

import java.util.List;

public interface UserService {
    List<user> getAll();
    user getById(int id);
    user getByName(String name);
    int add(user user);
    int deleteByName(String name);
    int deleteNyId(int id);
    int updateByName(String name, user user);
    int updateById(int id, user user);
}
