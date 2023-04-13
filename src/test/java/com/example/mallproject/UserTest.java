package com.example.mallproject;

import com.example.mallproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    UserService service;

    @Test
    void test() {

        System.out.println("userinfo:" + service.getUserAndRoleById(1));
    }
}
