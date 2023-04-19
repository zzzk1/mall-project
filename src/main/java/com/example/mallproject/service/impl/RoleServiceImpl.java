package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.Role;
import com.example.mallproject.mapper.RoleMapper;
import com.example.mallproject.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Page<Role> selectAll(int pageNum, int pageSize, String roleName) {
        QueryWrapper queryWrapper = new QueryWrapper<Role>().like("name", roleName);
        return roleMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
    }
}
