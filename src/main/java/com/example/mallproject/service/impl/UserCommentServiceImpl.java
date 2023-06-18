package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.entity.Comment;
import com.example.mallproject.entity.UserComment;
import com.example.mallproject.mapper.UserCommentMapper;
import com.example.mallproject.service.CommentService;
import com.example.mallproject.service.UserCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-06-17
 */
@Service
public class UserCommentServiceImpl extends ServiceImpl<UserCommentMapper, UserComment> implements UserCommentService {
    @Autowired
    private UserCommentMapper userCommentMapper;
    @Override
    public List<Long> getList(Long userId) {
        return userCommentMapper.getList(userId);
    }
}
