package com.example.mallproject;

import com.example.mallproject.pojo.User;
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
        List<User> Users = userService.getAll();
        for (User user : Users) {
            System.out.println(user);
        }
    }

    @Test
    void getByName() {
        User user;
        user = userService.getByName("add");
        System.out.println(user);
    }

    @Test
    void getById() {
        User user;
        user = userService.getById(1);
    }

    @Test
    void addUser() {
        User user = new User();
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
        User user = new User();
        user.setName("update");
        user.setPassword("update");
        userService.updateByName(name, user);
    }

    @Test
    void updateById() {
        User user = new User();
        user.setName("update");
        user.setPassword("update");
        userService.updateById(1, user);
    }
}
