package com.example.mallproject;

import com.example.mallproject.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandTest {

    @Autowired
    private BrandService brandService;

    @Test
    void test() {
        System.out.println(brandService.getSpuInfo(2, 1, 3));
    }
}
