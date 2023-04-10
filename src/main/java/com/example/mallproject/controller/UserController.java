package com.example.mallproject.controller;

import com.example.mallproject.common.api.Result;
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
    public Result<List<User>> getAll() {
        return Result.Success(userService.getAll());
    }

    @GetMapping("{name}")
    public Result<User> getUser(@PathVariable String name) {
        return Result.Success(userService.getUserByName(name));
    }

    @GetMapping("/id/{id}")
    public Result<User> getUser(@PathVariable Integer id) {
        return Result.Success( userService.getUserById(id));
    }

    @PostMapping
    public Result<Integer> addUser(@RequestBody User user) {
        return Result.Success(userService.addUser(user));
    }

    @DeleteMapping("{name}")
    public Result<Integer> deleteUser(@PathVariable String name) {
        return Result.Success(userService.deleteUserByName(name));
    }

    @DeleteMapping("/id/{id}")
    public Result<Integer> deleteUser(@PathVariable Integer id) {
        return Result.Success(userService.deleteUserNyId(id));
    }

    @PutMapping("{name}")
    public Result<Integer> updateUser(@PathVariable String name, @RequestBody User user) {
        return Result.Success(userService.updateUserByName(name, user));
    }

    @PutMapping("/id/{id}")
    public Result<Integer> updateUser(@PathVariable Integer id, @RequestBody User user) {
        return Result.Success(userService.updateUserById(id, user));
    }
}
