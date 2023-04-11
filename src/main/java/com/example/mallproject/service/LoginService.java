package com.example.mallproject.service;

import com.example.mallproject.common.api.Result;
import com.example.mallproject.pojo.User;

public interface LoginService {
    Result<User> login (User user);
    Result<User> register(User user);

}
