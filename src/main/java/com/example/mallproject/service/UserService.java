package com.example.mallproject.service;

import com.example.mallproject.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserByName(String name);
    int addUser(User user);
    int deleteUserByName(String name);
    int updateUserByName(String name, User user);
}
