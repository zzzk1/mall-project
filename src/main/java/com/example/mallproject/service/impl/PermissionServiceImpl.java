package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.entity.Permission;
import com.example.mallproject.entity.Role;
import com.example.mallproject.entity.RolePermission;
import com.example.mallproject.mapper.PermissionMapper;
import com.example.mallproject.mapper.RoleMapper;
import com.example.mallproject.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallproject.service.RolePermissionService;
import com.example.mallproject.service.RoleService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
