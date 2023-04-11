package com.example.mallproject.controller;

import com.example.mallproject.common.api.Result;
import com.example.mallproject.pojo.user;
import com.example.mallproject.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public Result<List<user>> getAll() {
        return Result.Success(service.getAll());
    }

    @GetMapping("{name}")
    public Result<user> getUser(@PathVariable String name) {
        return Result.Success(service.getByName(name));
    }

    @GetMapping("/id/{id}")
    public Result<user> getUser(@PathVariable Integer id) {
        return Result.Success( service.getById(id));
    }

    @PostMapping
    public Result<Integer> addUser(@RequestBody user user) {
        return Result.Success(service.add(user));
    }

    @DeleteMapping("{name}")
    public Result<Integer> deleteUser(@PathVariable String name) {
        return Result.Success(service.deleteByName(name));
    }

    @DeleteMapping("/id/{id}")
    public Result<Integer> deleteUser(@PathVariable Integer id) {
        return Result.Success(service.deleteNyId(id));
    }

    @PutMapping("{name}")
    public Result<Integer> updateUser(@PathVariable String name, @RequestBody user user) {
        return Result.Success(service.updateByName(name, user));
    }

    @PutMapping("/id/{id}")
    public Result<Integer> updateUser(@PathVariable Integer id, @RequestBody user user) {
        return Result.Success(service.updateById(id, user));
    }
}
