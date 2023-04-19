package com.example.mallproject;

import com.example.mallproject.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {
    @Autowired
    private OrderService orderService;
    @Test
    void getAll() {
        String name = null;
        orderService.selectAll(1, 10, "");
    }
}
