package com.example.mallproject.service;

import com.example.mallproject.entity.Comment;
import com.example.mallproject.entity.UserComment;
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
public interface UserCommentService extends IService<UserComment> {
    List<Long> getList(Long userId);
}
