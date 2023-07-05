package com.system.design;

import com.system.design.entity.dto.ManagerSystemNoticeDTO;
import com.system.design.service.ManagerSystemNoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;

@SpringBootTest
public class ManagerSystemNoticeTest {
    @Autowired
    private ManagerSystemNoticeService managerSystemNoticeService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Test
    public void send2AllUser() {
        LocalDateTime time = LocalDateTime.of(2023, 7,4, 16,27,13);
        System.out.println(managerSystemNoticeService.send2AllUser(time));
    }

    @Test
    public void send2user() {
        LocalDateTime time = LocalDateTime.of(2023, 7,4, 16,29,29);
        String userType = "vip";
        Long userId = 2L;
        ManagerSystemNoticeDTO managerSystemNoticeDTO = new ManagerSystemNoticeDTO();
        managerSystemNoticeDTO.setRecipientId(userId);
        managerSystemNoticeDTO.setType(userType);
        managerSystemNoticeDTO.setPublishTime(time);

        System.out.println(managerSystemNoticeService.send2User(managerSystemNoticeDTO));
    }

}
