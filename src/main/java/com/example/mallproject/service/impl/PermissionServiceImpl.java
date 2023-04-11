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
    public Permission getByName(String name) {
        query.eq("name", name);
        return permissionMapper.selectOne(query);
    }

    @Override
    public Permission getById(int id) {
        query.eq("id", id);
        return permissionMapper.selectOne(query);
    }

    @Override
    public int add(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int deleteByName(String name) {
        query.eq("name", name);
        return permissionMapper.delete(query);
    }

    @Override
    public int deleteById(int id) {
        return permissionMapper.deleteById(id);
    }

    @Override
    public int updateByName(String name, Permission permission) {
        query.eq("name", name);
        return permissionMapper.update(permission, query);
    }

    @Override
    public int updateById(int id, Permission permission) {
        query.eq("id", id);
        return permissionMapper.update(permission, query);
    }
}
