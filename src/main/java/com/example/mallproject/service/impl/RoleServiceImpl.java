package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.mapper.RoleMapper;
import com.example.mallproject.pojo.DO.Role;
import com.example.mallproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper mapper;

    @Override
    public List<Role> getAll() {
        QueryWrapper<Role> query = new QueryWrapper<Role>();
        return mapper.selectList(query);
    }

    @Override
    public Role getById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public Role getByName(String name) {
        QueryWrapper<Role> query = new QueryWrapper<>();
        query.eq("name", name);
        return mapper.selectOne(query);
    }

    @Override
    public int add(Role role) {
        return mapper.insert(role);
    }

    @Override
    public int deleteByName(String name) {
        QueryWrapper<Role> query = new QueryWrapper<>();
        query.eq("name", name);
        return mapper.delete(query);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public int updateByName(String name, Role role) {
        QueryWrapper<Role> query = new QueryWrapper<>();
        query.eq("name", name);
        return mapper.update(role, query);
    }

    @Override
    public int updateById(int id, Role role) {
        QueryWrapper<Role> query = new QueryWrapper<>();
        query.eq("id", id);
        return mapper.update(role, query);
    }
}
