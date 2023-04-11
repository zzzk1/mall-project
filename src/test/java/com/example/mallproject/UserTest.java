package com.example.mallproject;

import com.example.mallproject.pojo.user;
import com.example.mallproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    void getAll() {
        List<user> users = userService.getAll();
        for (com.example.mallproject.pojo.user user : users) {
            System.out.println(user);
        }
    }

    @Test
    void getByName() {
        user user;
        user = userService.getByName("add");
        System.out.println(user);
    }

    @Test
    void getById() {
        user user;
        user = userService.getById(1);
    }

    @Test
    void addUser() {
        user user = new user();
        user.setName("add");
        user.setPassword("add");
        userService.add(user);
    }

    @Test
    void deleteByName() {
        String name = "add";
        userService.deleteByName(name);
    }

    @Test
    void deleteById() {
        userService.deleteById(1);
    }

    @Test
    void updateByName() {
        String name = "add";
        user user = new user();
        user.setName("update");
        user.setPassword("update");
        userService.updateByName(name, user);
    }

    @Test
    void updateById() {
        user user = new user();
        user.setName("update");
        user.setPassword("update");
        userService.updateById(1, user);
    }
}
