package com.example.mallproject;

import com.example.mallproject.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {
    @Autowired
    private LoginService service;

    @Test
    void loginTest() {
    }

    @Test
    void registerTest() {

    }
}