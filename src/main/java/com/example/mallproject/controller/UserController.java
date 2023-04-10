package com.example.mallproject.controller;

import com.example.mallproject.pojo.User;
import com.example.mallproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("{name}")
    public User getUser(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/id/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("{name}")
    public int deleteUser(@PathVariable String name) {
        return userService.deleteUserByName(name);
    }

    @DeleteMapping("/id/{id}")
    public int deleteUser(@PathVariable Integer id) {
        return userService.deleteUserNyId(id);
    }

    @PutMapping("{name}")
    public int updateUser(@PathVariable String name, @RequestBody User user) {
        return userService.updateUserByName(name, user);
    }

    @PutMapping("/id/{id}")
    public int updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }
}
