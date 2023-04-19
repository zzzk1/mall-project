package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.Menu;
import com.example.mallproject.entity.User;
import com.example.mallproject.mapper.MenuMapper;
import com.example.mallproject.service.MenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Page<Menu> selectAll(int pageNum, int pageSize, String name) {
        Page<Menu> page = new Page<>(pageNum,pageSize);
        QueryWrapper queryWrapper = new QueryWrapper<Menu>().like("name", name);
        return menuMapper.selectPage(page, queryWrapper);
    }
}
