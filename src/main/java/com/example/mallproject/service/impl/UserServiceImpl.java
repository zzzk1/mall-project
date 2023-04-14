package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.entity.Role;
import com.example.mallproject.entity.User;
import com.example.mallproject.entity.UserRole;
import com.example.mallproject.mapper.UserMapper;
import com.example.mallproject.service.RoleService;
import com.example.mallproject.service.UserRoleService;
import com.example.mallproject.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserAndRoleById(long id) {
        //根据userid在关系表中找到userid和roleid
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq("user_id", id);
        //从找到的列中提取roleid在role表中查找
        UserRole userRole = userRoleService.getOne(userRoleQueryWrapper);
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("id", userRole.getRoleId());
        Role role = roleService.getOne(roleQueryWrapper);
        User user = userMapper.selectById(id);
        user.setRole(role);
        return user;
    }

    @Autowired
    private UserService userService;
    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", user.getName());
        queryWrapper.eq("password", user.getPassword());
        return userService.getOne(queryWrapper);
    }

    @Override
    public boolean enroll(User user) {
        return userService.save(user);
    }
}
