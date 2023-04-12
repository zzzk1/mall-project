package com.example.mallproject;

import com.example.mallproject.pojo.DO.Role;
import com.example.mallproject.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {
    @Autowired
    private RoleService service;
    @Test
    void getALl() {
        System.out.println(service.getAll());
    }

    @Test
    void getByName() {
        System.out.println(service.getByName("user"));
    }

    @Test
    void getById() {
        System.out.println(service.getById(2));
    }

    @Test
    void add() {
        Role role = new Role();
        role.setInfo("mod");
        role.setName("mod");
        System.out.println(service.add(role));
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
        Role role = new Role();
        role.setInfo("update");
        role.setName("update");
        System.out.println(service.updateByName("mod", role));
    }

    @Test
    void updateById() {
        Role role = new Role();
        role.setInfo("id");
        role.setName("id");
        System.out.println(service.updateById(1, role));
    }
}
