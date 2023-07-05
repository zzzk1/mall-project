package com.system.design.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Component
public class RedisStreamUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RecordId addMessage(String streamName, Map<Object, Object> map) {
        return redisTemplate.opsForStream().add(streamName, map);
    }

    public String addGroup(String streamName, String groupName, ReadOffset readOffset) {
        String group = null;
        //获取是否已有该名称 stream
        Long size = redisTemplate.opsForStream().size(streamName);
        if (size == null || size < 1) {
            // 没有设置读取规则
            group = redisTemplate.opsForStream().createGroup(streamName,readOffset, groupName);
        }
        if (size != null && size >= 1) {
            // 已有直接创建新的分组
            group = redisTemplate.opsForStream().createGroup(streamName, groupName);
        }
        return group;
    }

    public MapRecord<String, Object, Object> readOne(String streamName,
                                                     String groupName,
                                                     String consumerName,
                                                     Duration duration,
                                                     ReadOffset readOffset) {
        List<MapRecord<String, Object, Object>> recordList = redisTemplate.opsForStream().read(
                // 创建消费者
                Consumer.from(groupName, consumerName),
                // 每次读取 1条消息
                StreamReadOptions.empty().count(1).block(duration),
                StreamOffset.create(streamName, readOffset)
        );
        if (recordList == null || recordList.isEmpty()) {
            return null;
        }
        return recordList.get(0);
    }

    public Long acknowledge(String streamName,String groupName, MapRecord<String, Object, Object> record) {
        return redisTemplate.opsForStream().acknowledge(streamName, groupName, record.getId());
    }

    public Long delete(String streamName, MapRecord<String, Object, Object> record) {
        return redisTemplate.opsForStream().delete(streamName, record.getId());
    }
}
