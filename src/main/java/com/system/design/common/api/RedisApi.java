package com.system.design.common.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisApi {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public  void set(String key, Object object) throws Exception {
        try {
            redisTemplate.opsForValue().set(key, object);
        } catch (Exception e) {
            throw new Exception("添加失败");
        }
    }

    public void get(String key) throws Exception {
        try {
            redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            throw new Exception("获取失败");
        }
    }

    public void rightPop(String queue) throws Exception {
        try {
            redisTemplate.opsForList().rightPop(queue);
        } catch (Exception e) {
            throw new Exception("获取失败");
        }
    }

    public void leftPush(String queue, Object message) throws Exception {
        try {
            redisTemplate.opsForList().leftPush(queue, message);
        } catch (Exception e) {
            throw new Exception("获取失败");
        }
    }
}
