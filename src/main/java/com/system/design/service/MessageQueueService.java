package com.system.design.service;

import com.system.design.common.api.NameSpace;
import com.system.design.common.util.RedisUtil;
import com.system.design.common.util.ThreadLocalUtil;
import com.system.design.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.HashMap;

@Slf4j
@Service
public class MessageQueueService {
    @Autowired
    private RedisUtil redisUtil;

    public HashMap<Long, MenuSelectionManager> sentMessage(String queue) {
        return (HashMap<Long, MenuSelectionManager>) redisUtil.popQueue(queue);
    }

    public void putMsgFromCache() {
        User user = (User) ThreadLocalUtil.get("userInfo");
        Long userId = user.getUserId();

        String singleKey = NameSpace.SINGLE_USER + userId;
        String allKey = NameSpace.ALL_USER + LocalDateTime.now();

        try {
            Object obj = redisUtil.get(singleKey);
            if (obj != null) {
                redisUtil.pushQueue("single", obj);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Object obj = redisUtil.get(allKey);
            if (obj != null) {
                redisUtil.pushQueue("all", obj);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
