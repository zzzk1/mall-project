package com.example.mallproject.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.common.utils.PageUtil;
import com.example.mallproject.common.utils.RedisUtils;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.entity.Comment;
import com.example.mallproject.entity.UserComment;
import com.example.mallproject.mapper.CommentMapper;
import com.example.mallproject.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallproject.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
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
    @Resource
    private RedisUtils redisUtils;

    @Override
    public boolean add(Long userId, Comment comment) {
        UserComment userComment = new UserComment();
        ValidatorUtils.checkNull(userId, "userId");
        ValidatorUtils.checkNull(comment, "comment");
        userComment.setUserId(userId);
        userComment.setCommentId(comment.getId());
        return commentService.save(comment) && userCommentService.save(userComment);
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
        String key =  "User{id:" + userId + "}" + "Comments";
        List<Comment> result = (List<Comment>) redisUtils.get(key);
        if (result == null) {
            System.out.println("缓存未命中");
            List<Comment> comments = commentService.listByIds(ids);
            redisUtils.set(key, comments);
            return comments;
        } else {
            System.out.println("缓存命中");
            return result;
        }
    }

    @Override
    public Page<Comment> getPage(Integer curr, Integer size) {
        ValidatorUtils.checkNull(curr, "curr");
        ValidatorUtils.checkNull(size, "size");

        String key = "Comments{page:" + curr + "}";
        List<Comment> value = (List<Comment>) redisUtils.get(key);
        if (value != null) {
            System.out.println("缓存命中");
        } else {
            System.out.println("缓存未命中");
            value  = sortComment(commentService.list());
            ValidatorUtils.checkNull(value, "result");
            redisUtils.set(key, PageUtil.listToPage(value, curr, size));
        }
        return PageUtil.listToPage(value, curr, size);
    }

    private List<Comment> sortComment(List<Comment> comments) {
        ValidatorUtils.checkNull(comments, "comments");

        HashMap<Long, Comment> map = new HashMap<>();
        for (Comment comment : comments) {
            map.put(comment.getId(), comment);
        }

        List<Comment> result = new ArrayList<>();

        for (Comment comment : comments) {
            if (comment.getPid() == 0) {
                result.add(comment);
            } else {
                Comment parent = map.get(comment.getPid());
                parent.getChildren().add(comment);
            }
        }

        return result;
    }
}
