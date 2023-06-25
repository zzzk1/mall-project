package com.example.mallproject.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.entity.Comment;
import com.example.mallproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-06-25
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/page")
    public Result<Page<Comment>> commentPage(@RequestParam Integer curr, @RequestParam Integer size, @RequestParam Integer total) {
        return Result.Success(commentService.getComments(curr, size, total));
    }
}
