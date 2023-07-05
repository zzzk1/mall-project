package com.system.design.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StreamOperations;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public  void set(String key, Object object) throws Exception {
        try {
            redisTemplate.opsForValue().set(key, object);
        } catch (Exception e) {
            throw new Exception("添加失败");
        }
    }

    public Object get(String key) throws Exception {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            throw new Exception("获取失败");
        }
    }

    public void pushQueue(String queue, Object object) {
        redisTemplate.opsForList().leftPush(queue, object);
    }

    public Object popQueue(String queue) {
        return redisTemplate.opsForList().rightPop(queue);
    }
}
