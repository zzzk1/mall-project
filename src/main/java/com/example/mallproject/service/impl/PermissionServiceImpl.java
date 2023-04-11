package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.mapper.PermissionMapper;
import com.example.mallproject.pojo.Permission;
import com.example.mallproject.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    QueryWrapper<Permission> query = new QueryWrapper<>();
    @Override
    public List<Permission> getAll() {
        return permissionMapper.selectList(query);
    }

    @Override
    public Permission getPermissionByName(String name) {
        query.eq("name", name);
        return permissionMapper.selectOne(query);
    }

    @Override
    public Permission getPermissionById(int id) {
        query.eq("id", id);
        return permissionMapper.selectOne(query);
    }

    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int deletePermissionByName(String name) {
        query.eq("name", name);
        return permissionMapper.delete(query);
    }

    @Override
    public int deletePermissionNyId(int id) {
        return permissionMapper.deleteById(id);
    }

    @Override
    public int updatePermissionByName(String name, Permission permission) {
        query.eq("name", name);
        return permissionMapper.update(permission, query);
    }

    @Override
    public int updatePermissionById(int id, Permission permission) {
        query.eq("id", id);
        return permissionMapper.update(permission, query);
    }
}
