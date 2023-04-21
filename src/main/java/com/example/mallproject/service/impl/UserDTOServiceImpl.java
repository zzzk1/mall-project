package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.entity.Role;
import com.example.mallproject.service.RoleMenuService;
import com.example.mallproject.service.RoleService;
import com.example.mallproject.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDTOServiceImpl implements UserDTOService {

    @Autowired
    private RoleService roleService;
    //通过用户表中的role字段查找roleId
    private int getRoleId(String role) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>().eq("flag", role);
        queryWrapper.select("id");
        Role selectRole = roleService.getOne(queryWrapper);
        return selectRole.getId();
    }

    @Autowired
    private RoleMenuService roleMenuService;
    @Override
    public List<Integer> getLoginUserMenuIds(String role) {
        int roleId = getRoleId(role);
        return roleMenuService.getMenusById(roleId);
    }
}
