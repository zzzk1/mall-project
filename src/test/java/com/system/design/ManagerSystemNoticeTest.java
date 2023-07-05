package com.system.design;

import com.system.design.entity.dto.ManagerSystemNoticeDTO;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import com.system.design.mapper.ManagerSystemNoticeMapper;
import com.system.design.service.ManagerSystemNoticeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ManagerSystemNoticeTest {
    @Autowired
    private ManagerSystemNoticeService managerSystemNoticeService;

    @Test
    public void send2AllUser() throws Exception {
        LocalDateTime time = LocalDateTime.of(2023, 7,4, 16,27,13);
        Map<Long, ManagerSystemNoticeVo> messages = managerSystemNoticeService.send2AllUser(time);
    }

    @Test
    public void send2user() {
        LocalDateTime time = LocalDateTime.of(2023, 7,4, 16,29,29);
        String userType = "single";
        Long userId = 2L;
        Map<Long, ManagerSystemNoticeVo> messages = managerSystemNoticeService.send2User(userId, time);
    }

    @Autowired
    private ManagerSystemNoticeMapper managerSystemNoticeMapper;
    @Test
    public void update() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        managerSystemNoticeMapper.updateState(ids);
    }
}
