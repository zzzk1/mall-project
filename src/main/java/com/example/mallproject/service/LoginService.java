package com.example.mallproject.service;

import com.example.mallproject.entity.User;

public interface LoginService {
    User login(User user);

    boolean enroll(User user);
}
