package com.example.mallproject.controller;

import com.example.mallproject.common.api.Result;
import com.example.mallproject.pojo.DO.Role;
import com.example.mallproject.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(tags = "角色接口")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping
    public Result<List<Role>> get() {
        return Result.Success(service.getAll());
    }

    @GetMapping("{name}")
    public Result<Role> getByName(@PathVariable String name) {
        return Result.Success(service.getByName(name));
    }

    @GetMapping("/id/{id}")
    public Result<Role> getById(@PathVariable Integer id) {
        return Result.Success( service.getById(id));
    }

    @PostMapping
    public Result<Integer> add(@RequestBody Role role) {
        return Result.Success(service.add(role));
    }

    @DeleteMapping("{name}")
    public Result<Integer> deleteByName(@PathVariable String name) {
        return Result.Success(service.deleteByName(name));
    }

    @DeleteMapping("/id/{id}")
    public Result<Integer> deleteById(@PathVariable Integer id) {
        return Result.Success(service.deleteById(id));
    }

    @PutMapping("{name}")
    public Result<Integer> updateByName(@PathVariable String name, @RequestBody Role role) {
        return Result.Success(service.updateByName(name, role));
    }

    @PutMapping("/id/{id}")
    public Result<Integer> updateById(@PathVariable Integer id, @RequestBody Role role) {
        return Result.Success(service.updateById(id, role));
    }
}
