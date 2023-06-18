package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.entity.Comment;
import com.example.mallproject.entity.UserComment;
import com.example.mallproject.mapper.CommentMapper;
import com.example.mallproject.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallproject.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-06-17
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserCommentService userCommentService;

    @Override
    public boolean add(Long userId, Comment comment) {
        UserComment userComment = new UserComment();
        ValidatorUtils.checkNull(userId, "userId");
        ValidatorUtils.checkNull(comment, "comment");
        userComment.setUserId(userId);
        userComment.setCommentId(comment.getId());
        return  commentService.save(comment) && userCommentService.save(userComment);
    }

    @Override
    public boolean delete(Long commentId) {
        ValidatorUtils.checkNull(commentId, "commentId");
        return removeOne(commentId) && commentService.removeById(commentId);
    }

    private boolean removeOne(Long commentId) {
        QueryWrapper<UserComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comment_id", commentId);
        return userCommentService.remove(queryWrapper);
    }

    @Override
    public List<Comment> getList(Long userId) {
        List<Long> ids = userCommentService.getList(userId);
        ValidatorUtils.checkNull(ids, "用户评论数");
        return commentService.listByIds(ids);
    }
}
