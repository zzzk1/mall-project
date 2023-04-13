package com.example.mallproject.service;

import com.example.mallproject.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mallproject.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */
public interface RoleService extends IService<Role> {
    Role getUsersAndRoleById(int id);
    Role getPermissionAndRoleById(int id);
}
