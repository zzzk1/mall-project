package com.example.mallproject.controller;


import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.entity.Comment;
import com.example.mallproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-06-17
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("list/{userId}")
    public Result<List<Comment>> getList(@PathVariable Long userId) {
        ValidatorUtils.checkNull(userId, "userId");
        return Result.Success(commentService.getList(userId));
    }

    @PostMapping("add")
    public Result<Boolean> add(@RequestParam Long userId, @RequestBody Comment comment) {
        ValidatorUtils.checkNull(userId, "userId");
        ValidatorUtils.checkNull(comment, "comment");
        return Result.Success(commentService.add(userId, comment));
    }

    @DeleteMapping("delete/{commentId}")
    public Result<Boolean> delete(@PathVariable Long commentId) {
        ValidatorUtils.checkNull(commentId, "commentId");
        return Result.Success(commentService.delete(commentId));
    }
}
