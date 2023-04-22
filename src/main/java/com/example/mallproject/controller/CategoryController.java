package com.example.mallproject.controller;


import com.example.mallproject.common.api.Result;
import com.example.mallproject.entity.Category;
import com.example.mallproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result<List<Category>> getAllCategory() {
        return Result.Success(categoryService.getAllCategory(), "查询成功");
    }

    @GetMapping("{pid}")
    public Result<List<Category>> getCategoryByPid(@PathVariable Long pid) {
        return Result.Success(categoryService.getCategoryByPid(pid), "查询成功");
    }
}
