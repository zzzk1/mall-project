package com.example.mallproject;

import com.example.mallproject.pojo.User;
import com.example.mallproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    void getAll() {
        List<User> users = userService.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void getByName() {
        User user;
        user = userService.getUserByName("add");
        System.out.println(user);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setName("add");
        user.setPassword("add");
        userService.addUser(user);
    }

    @Test
    void deleteByName() {
        String name = "add";
        userService.deleteUserByName(name);
    }

    @Test
    void updateByName() {
        String name = "add";
        User user = new User();
        user.setName("update");
        user.setPassword("update");
        userService.updateUserByName(name, user);
    }
}
