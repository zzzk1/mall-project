package com.system.design;

import com.system.design.service.ManagerSystemNoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ManagerSystemNoticeTest {
    @Autowired
    private ManagerSystemNoticeService managerSystemNoticeService;

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
        System.out.println(managerSystemNoticeService.send2User(userId, userType, time));
    }

}
