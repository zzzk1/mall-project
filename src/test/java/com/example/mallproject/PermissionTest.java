package com.example.mallproject;

import com.example.mallproject.pojo.Permission;
import com.example.mallproject.service.PermissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PermissionTest {
    @Autowired
    private PermissionService service;
    @Test
    void getALl() {
        System.out.println(service.getAll());
    }

    @Test
    void getByName() {
        System.out.println(service.getByName("mod"));
    }

    @Test
    void getById() {
        System.out.println(service.getById(2));
    }

    @Test
    void add() {
        Permission permission = new Permission();
        permission.setModule("mod");
        permission.setName("mod");
        System.out.println(service.add(permission));
    }

    @Test
    void deleteByName() {
        System.out.println(service.deleteByName("mod"));
    }

    @Test
    void deleteById() {
        System.out.println(service.deleteById(1));
    }

    @Test
    void updateByName() {
        Permission permission = new Permission();
        permission.setName("update");
        permission.setModule("update");
        System.out.println(service.updateByName("mod", permission));
    }

    @Test
    void updateById() {
        Permission permission = new Permission();
        permission.setName("update");
        permission.setModule("update");
        System.out.println(service.updateById(1, permission));
    }
}
