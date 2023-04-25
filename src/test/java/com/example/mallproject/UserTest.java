package com.example.mallproject;

import com.example.mallproject.entity.dto.UserDTO;
import com.example.mallproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    UserService service;


    @Test
    void login() {
        UserDTO user = new UserDTO();
        user.setUsername("admin");
        user.setPassword("admin");
        service.login(user);
    }

    @Test
    void page() {
        service.selectAll(1, 5, "a");
    }

    @Test
    void test() {

        System.out.println(0.2 * 0.2);
    }
}
