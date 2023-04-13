package com.example.mallproject.service;

import com.example.mallproject.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */
public interface CategoryService extends IService<Category> {

    List<Category> getAllCategory();

    List<Category> getCategoryById(Long pid);
}
