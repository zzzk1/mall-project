package com.system.design.service;

import com.system.design.common.util.ThreadLocalUtil;
import com.system.design.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class PullNoticeService {
    @Autowired
    private ManagerSystemNoticeService managerSystemNoticeService;

    @Scheduled(fixedDelay = 360000)
    private void pullAllUserMsg() {
        LocalDateTime now = LocalDateTime.now();
        log.info(String.valueOf(now));
        log.info("拉取发送给所有用户的通知");
        managerSystemNoticeService.send2AllUser(now);
    }


    public void pullSingleUserMsg() {
        LocalDateTime now = LocalDateTime.now();
        log.info(String.valueOf(now));
        log.info("拉取发送给指定用户的通知");
        User user = (User) ThreadLocalUtil.get("userInfo");
        managerSystemNoticeService.send2User(user.getUserId(), now);
    }
}
