package com.example.mallproject;

import com.example.mallproject.entity.vo.UserVO;
import com.example.mallproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    UserService service;

    @Test
    void page() {
        service.selectAll(1, 5, "a");
    }

    @Test
    void test() {

        System.out.println(0.2 * 0.2);
    }
}
