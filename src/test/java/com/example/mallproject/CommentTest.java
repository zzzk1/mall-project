package com.example.mallproject;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.Comment;
import com.example.mallproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CommentTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void getPage() {
        Page<Comment> commentPage = commentService.getComments(1, 10, 200);
        System.out.println(commentPage);
    }
}
