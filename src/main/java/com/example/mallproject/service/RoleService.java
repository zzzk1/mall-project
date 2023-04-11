package com.example.mallproject.service;

import com.example.mallproject.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getById(int id);
    Role getByName(String name);
    int add(Role role);
    int deleteByName(String name);
    int deleteById(int id);
    int updateByName(String name, Role role);
    int updateById(int id, Role role);
}
