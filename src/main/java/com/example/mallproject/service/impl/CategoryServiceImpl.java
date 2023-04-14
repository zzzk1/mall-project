package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.entity.Category;
import com.example.mallproject.mapper.CategoryMapper;
import com.example.mallproject.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<Category> getAllCategory() {
        List<Category> data = categoryService.list();
        HashMap<Long, Category> map = new HashMap<>();

        for (Category category : data) {
            map.put(category.getId(), category);
        }

        List<Category> list = new ArrayList<>();
        for (Category child : data) {
            if (child.getParentCid() == 0) {
                list.add(child);
            } else {
                Category parent = map.get(child.getParentCid());
                parent.getChildren().add(child);
            }
        }
        return list;
    }

    @Override
    public List<Category> getCategoryByPid(Long pid) {
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.eq("parent_cid", pid);
        return categoryService.list(categoryQueryWrapper);
    }
}
