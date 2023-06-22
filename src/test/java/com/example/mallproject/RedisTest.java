package com.example.mallproject;

import com.example.mallproject.common.utils.RedisUtils;
import com.example.mallproject.entity.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {
    @Resource
    private RedisUtils redisUtils;

    @Test
    public void get() {
        System.out.println(redisUtils.get("user"));
    }

    @Test
    public void set() {
        UserVO user = new UserVO();
        user.setUsername("admin");
        redisUtils.set("user", String.valueOf(user));
    }

    @Test
    public void delete() {
        redisUtils.delete("user");
    }
}
