package com.example.mallproject;

import com.example.mallproject.entity.Comment;
import com.example.mallproject.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void getList() {
        commentService.getList(1L);
    }

    @Test
    public void aad() {
        Long userId = 1L;
        Comment comment = new Comment();
        comment.setId(999L);
        comment.setContact("添加测试");
        commentService.add(userId, comment);
    }

    @Test
    public void delete() {
        Long commentId = 104L;
        commentService.delete(commentId);
    }
}
