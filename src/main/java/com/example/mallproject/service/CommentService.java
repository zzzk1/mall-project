package com.example.mallproject.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-06-25
 */
public interface CommentService extends IService<Comment> {
    Page<Comment> getComments(Integer curr, Integer size, Integer total);
    List<Comment> getSubComment(List<Long> rootIds);
}
