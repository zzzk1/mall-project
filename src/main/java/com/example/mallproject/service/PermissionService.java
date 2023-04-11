package com.example.mallproject.service;

import com.example.mallproject.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getAll();
    Permission getByName(String name);
    Permission getById(int id);
    int add(Permission permission);
    int deleteByName(String name);
    int deleteById(int id);
    int updateByName(String name, Permission permission);
    int updateById(int id, Permission permission);
}
