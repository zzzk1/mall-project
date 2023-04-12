package com.example.mallproject;

import com.example.mallproject.entity.User;
import com.example.mallproject.service.LoginService;
import com.example.mallproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {
    @Autowired
    private LoginService loginService;

    @Test
    void login() {
        User user = new User();
        user.setName("admin");
        user.setPassword("admin");
        System.out.println(loginService.login(user));
    }

    @Test
    void enroll() {
        User user = new User();
        user.setName("zzzk1");
        user.setPassword("zzzk1");
        System.out.println(loginService.enroll(user));
    }
}
