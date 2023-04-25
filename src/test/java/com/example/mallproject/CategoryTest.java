package com.example.mallproject;

import com.example.mallproject.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryTest {
    @Autowired
    private CategoryService categoryService;

}
