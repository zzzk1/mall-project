package com.example.mallproject;

import com.example.mallproject.mapper.UserCommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserCommentTest {
    @Autowired
    private UserCommentMapper userCommentMapper;

    @Test
    void getList() {
        userCommentMapper.getList(1L);
    }

}
