package com.example.mallproject.controller;

import com.example.mallproject.common.api.Result;
import com.example.mallproject.pojo.Permission;
import com.example.mallproject.service.PermissionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "功能接口")
@RestController
public class PermissionController {
    @Autowired
    private PermissionService service;

    @GetMapping
    public Result<List<Permission>> getAll() {
        return Result.Success(service.getAll());
    }

    @GetMapping("{name}")
    public Result<Permission> getUser(@PathVariable String name) {
        return Result.Success(service.getByName(name));
    }

    @GetMapping("/id/{id}")
    public Result<Permission> getUser(@PathVariable Integer id) {
        return Result.Success( service.getById(id));
    }

    @PostMapping
    public Result<Integer> addUser(@RequestBody Permission permission) {
        return Result.Success(service.add(permission));
    }

    @DeleteMapping("{name}")
    public Result<Integer> deleteUser(@PathVariable String name) {
        return Result.Success(service.deleteByName(name));
    }

    @DeleteMapping("/id/{id}")
    public Result<Integer> deleteUser(@PathVariable Integer id) {
        return Result.Success(service.deleteById(id));
    }

    @PutMapping("{name}")
    public Result<Integer> updateUser(@PathVariable String name, @RequestBody Permission permission) {
        return Result.Success(service.updateByName(name, permission));
    }

    @PutMapping("/id/{id}")
    public Result<Integer> updateUser(@PathVariable Integer id, @RequestBody Permission permission) {
        return Result.Success(service.updateById(id, permission));
    }
}
