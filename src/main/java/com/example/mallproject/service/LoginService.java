package com.example.mallproject.service;

import com.example.mallproject.common.api.Result;
import com.example.mallproject.pojo.User;

public interface LoginService {
    Result<User> login(String name, String password);
    Result<User> register(String name, String password);

}
