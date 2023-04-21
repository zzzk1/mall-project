package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.Menu;
import com.example.mallproject.entity.Role;
import com.example.mallproject.entity.RoleMenu;
import com.example.mallproject.mapper.RoleMapper;
import com.example.mallproject.service.MenuService;
import com.example.mallproject.service.RoleMenuService;
import com.example.mallproject.service.RoleService;
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
 * @since 2023-04-19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Page<Role> selectAll(int pageNum, int pageSize, String roleName) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>().like("name", roleName);
        return roleMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
    }

    @Autowired
    private RoleMenuService roleMenuService;
    @Override
    public Boolean updateRoleMenuInfo(int rid, List<Integer> menusId) {
        roleMenuService.deleteById(rid);
        for (Integer menuId : menusId) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(rid);
            roleMenu.setMenuId(menuId);
            roleMenuService.saveOrUpdate(roleMenu);
        }
        return true;
    }

    @Override
    public List<Integer> getMenusById(int rid) {
        return roleMenuService.getMenusById(rid);
    }
}
