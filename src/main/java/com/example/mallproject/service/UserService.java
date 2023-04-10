package com.example.mallproject.service;

import com.example.mallproject.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(int id);
    User getUserByName(String name);
    int addUser(User user);
    int deleteUserByName(String name);
    int deleteUserNyId(int id);
    int updateUserByName(String name, User user);
    int updateUserById(int id, User user);
}
