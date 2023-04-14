package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.entity.*;
import com.example.mallproject.mapper.RoleMapper;
import com.example.mallproject.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getUsersAndRoleById(long id) {

       //在表中找到roleid与userid的所有列
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq("role_id", id);
        List<UserRole> userRoles = userRoleService.list(userRoleQueryWrapper);

        //从每个列中取出对应的user_id来查找
        List<Long> userIds = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            userIds.add(userRole.getUserId());
        }
        List<User> users = userService.listByIds(userIds);

        //找到role
        Role role = roleMapper.selectById(id);
        role.setUsers(users);
        return role;
    }

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Override
    public Role getPermissionAndRoleById(long id) {
        //获取permissionid 与 roleid的所有列
        QueryWrapper<RolePermission> rolePermissionQueryWrapper = new QueryWrapper<>();
        rolePermissionQueryWrapper.eq("role_id", id);
        List<RolePermission> rolePermissions = rolePermissionService.list(rolePermissionQueryWrapper);

        //获取所有permissionid并查找
        List<Long> permissionIds = new ArrayList<>();
        for (RolePermission rolePermission : rolePermissions) {
            permissionIds.add(rolePermission.getPermissionId());
        }
        List<Permission> permissions = permissionService.listByIds(permissionIds);

        //找到对应的role
        Role role = roleMapper.selectById(id);
        role.setPermissions(permissions);
        return role;
    }
}
