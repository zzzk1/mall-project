package com.example.mallproject.controller;


import com.example.mallproject.Annotation.PermissionRequired;
import com.example.mallproject.common.api.Logical;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.api.UserType;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.entity.Role;
import com.example.mallproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    //角色对应的用户
    @PermissionRequired(userType = {UserType.ADMIN}, logical = Logical.OR)
    @GetMapping("{id}")
    public Result<Role> getRoleAndUsersById(@PathVariable int id) {
        return Result.Success(roleService.getUsersAndRoleById(id));
    }
}
