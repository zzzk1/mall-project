package com.example.mallproject;

import com.example.mallproject.entity.vo.OrderVO;
import com.example.mallproject.mapper.OrderMapper;
import com.example.mallproject.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderTest {
    @Autowired
    private OrderService orderService;
    @Test
    void getAll() {
        String name = null;
        orderService.selectAll(1, 10, "Brenda Young");
    }

    @Test
    void getAllBySpuName() {
        String spuName = "华为1";
        System.out.println(orderService.getPageBySpuName(1, 10, spuName, "Brenda Young"));
    }

    @Autowired
    private OrderMapper orderMapper;
    @Test
    void getTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(4L);
        ids.add(5L);
        ids.add(6L);
        List<OrderVO> orderVOS = orderMapper.selectOrderDTO(ids, "Joseph White");
        for (OrderVO orderVO : orderVOS) {
            System.out.println(orderVO);
        }
    }
}
