package com.example.mallproject.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.entity.Menu;

import com.example.mallproject.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-19
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public Result<List<Menu>> getAll(@RequestParam(defaultValue = "") String name) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        List<Menu> list = menuService.list(queryWrapper);
        List<Menu> parentNode = list.stream().filter(menu -> menu.getPid() == null).collect(Collectors.toList());
        for (Menu menu : parentNode) {
            menu.setChildren(list.stream().filter(m -> menu.getId().equals(m.getPid())).collect(Collectors.toList()));
        }
        return Result.Success(parentNode);

    }

    //新增或修改
    @PostMapping
    public Result<Boolean> edit(@RequestBody Menu menu) {
        ValidatorUtils.checkNull(menu, "menu");
        return Result.Success(menuService.saveOrUpdate(menu));
    }

    @DeleteMapping(("{id}"))
    public Result<Boolean> delete(@PathVariable long id) {
        return Result.Success(menuService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result<Boolean> deleteBatchId(@RequestBody List<Long> ids) {
        return Result.Success(menuService.removeBatchByIds(ids));
    }
}
