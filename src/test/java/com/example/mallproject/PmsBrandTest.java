package com.example.mallproject;

import com.example.mallproject.pojo.DO.PmsBrand;
import com.example.mallproject.service.PmsBrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PmsBrandTest {
    @Autowired
    private PmsBrandService brandService;
    @Test
    void getAll() {
        List<PmsBrand> brands = brandService.getAll();
        for (PmsBrand user : brands) {
            System.out.println(user);
        }
    }

    @Test
    void getByName() {
        PmsBrand pmsBrand;
        pmsBrand = brandService.getByName("小米");
        System.out.println(pmsBrand);
    }

    @Test
    void getById() {
        PmsBrand pmsBrand;
        pmsBrand = brandService.getById(1);
    }

    @Test
    void add() {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setName("小米");
        pmsBrand.setDescription("小米");
//        pmsBrand.setName("大米");
//        pmsBrand.setDescription("大米");
        brandService.add(pmsBrand);
    }

    @Test
    void deleteByName() {
        String name = "小米";
        brandService.deleteByName(name);
    }

    @Test
    void deleteById() {
        brandService.deleteById(1);
    }

    @Test
    void updateByName() {
        String name = "大米";
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setName("中米");
        pmsBrand.setDescription("中米");
        brandService.updateByName(name, pmsBrand);
    }

    @Test
    void updateById() {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setName("小中米");
        pmsBrand.setDescription("小中米");
        brandService.updateById(1, pmsBrand);
    }
}
