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
 * @since 2023-06-17
 */
public interface CommentService extends IService<Comment> {
    boolean add(Long userId, Comment comment);
    boolean delete(Long commentId);
    List<Comment> getList(Long userId);
    Page<Comment> getPage(Integer curr, Integer size);
}
