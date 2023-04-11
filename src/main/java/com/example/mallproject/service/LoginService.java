package com.example.mallproject.service;

import com.example.mallproject.common.api.Result;
import com.example.mallproject.pojo.User;

public interface LoginService {
    User login(String name, String password);
    User register(String name, String password);

}
