package com.system.design;

import com.system.design.entity.dto.ManagerSystemNoticeDTO;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import com.system.design.mapper.ManagerSystemNoticeMapper;
import com.system.design.service.ManagerSystemNoticeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ManagerSystemNoticeTest {
    @Autowired
    private ManagerSystemNoticeService managerSystemNoticeService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void send2AllUser() throws Exception {
        LocalDateTime time = LocalDateTime.of(2023, 7,4, 16,27,13);
    }

    @Autowired
    private ManagerSystemNoticeMapper managerSystemNoticeMapper;
    @Test
    public void getMessage() {
        Date time = new Date();
        String userType = "single";
        Long userId = 1L;
        managerSystemNoticeService.getMessage(time, userId);
        System.out.println(redisTemplate.opsForValue().get("userId:1"));
    }

    @Test
    public void update() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        managerSystemNoticeMapper.updateState(ids);
    }
}
