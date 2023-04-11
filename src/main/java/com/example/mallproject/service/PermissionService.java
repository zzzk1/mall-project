package com.example.mallproject.service;

import com.example.mallproject.pojo.Permission;
import com.example.mallproject.pojo.User;

import java.util.List;

public interface PermissionService {
    List<Permission> getAll();
    Permission getPermissionByName(String name);
    Permission getPermissionById(int id);
    int addPermission(Permission permission);
    int deletePermissionByName(String name);
    int deletePermissionNyId(int id);
    int updatePermissionByName(String name, Permission permission);
    int updatePermissionById(int id, Permission permission);
}
