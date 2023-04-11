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

    @Override
    public List<Permission> getAll() {
        QueryWrapper<Permission> query = new QueryWrapper<>();
        return permissionMapper.selectList(query);
    }

    @Override
    public Permission getByName(String name) {
        QueryWrapper<Permission> query = new QueryWrapper<>();
        query.eq("name", name);
        return permissionMapper.selectOne(query);
    }

    @Override
    public Permission getById(int id) {
        QueryWrapper<Permission> query = new QueryWrapper<>();
        query.eq("id", id);
        return permissionMapper.selectOne(query);
    }

    @Override
    public int add(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int deleteByName(String name) {
        QueryWrapper<Permission> query = new QueryWrapper<>();
        query.eq("name", name);
        return permissionMapper.delete(query);
    }

    @Override
    public int deleteById(int id) {
        return permissionMapper.deleteById(id);
    }

    @Override
    public int updateByName(String name, Permission permission) {
        QueryWrapper<Permission> query = new QueryWrapper<>();
        query.eq("name", name);
        return permissionMapper.update(permission, query);
    }

    @Override
    public int updateById(int id, Permission permission) {
        QueryWrapper<Permission> query = new QueryWrapper<>();
        query.eq("id", id);
        return permissionMapper.update(permission, query);
    }
}
