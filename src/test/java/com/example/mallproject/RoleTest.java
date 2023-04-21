package com.example.mallproject;

import com.example.mallproject.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {
    @Autowired
    private RoleService roleService;
    @Test
    void Test() {
        System.out.println(roleService.getMenusById(1));
    }
}
