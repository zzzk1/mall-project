package com.system.design.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Component
public class RedisUtil {
    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    public  void set(String key, Object object) {
            redisTemplate.opsForValue().set(key, object);
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void pushQueue(String queue, Object object) {
        redisTemplate.opsForList().leftPush(queue, object);
    }

    public Object popQueue(String queue) {
        return redisTemplate.opsForList().rightPop(queue);
    }
}
