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
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService service;

    @GetMapping
    public Result<List<Permission>> getAll() {
        return Result.Success(service.getAll());
    }

    @GetMapping("{name}")
    public Result<Permission> getPermission(@PathVariable String name) {
        return Result.Success(service.getByName(name));
    }

    @GetMapping("/id/{id}")
    public Result<Permission> getPermission(@PathVariable Integer id) {
        return Result.Success( service.getById(id));
    }

    @PostMapping
    public Result<Integer> addPermission(@RequestBody Permission permission) {
        return Result.Success(service.add(permission));
    }

    @DeleteMapping("{name}")
    public Result<Integer> deletePermission(@PathVariable String name) {
        return Result.Success(service.deleteByName(name));
    }

    @DeleteMapping("/id/{id}")
    public Result<Integer> deletePermission(@PathVariable Integer id) {
        return Result.Success(service.deleteById(id));
    }

    @PutMapping("{name}")
    public Result<Integer> updatePermission(@PathVariable String name, @RequestBody Permission permission) {
        return Result.Success(service.updateByName(name, permission));
    }

    @PutMapping("/id/{id}")
    public Result<Integer> updatePermission(@PathVariable Integer id, @RequestBody Permission permission) {
        return Result.Success(service.updateById(id, permission));
    }
}
