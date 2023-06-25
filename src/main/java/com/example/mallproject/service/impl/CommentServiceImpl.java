package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.Comment;
import com.example.mallproject.mapper.CommentMapper;
import com.example.mallproject.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-06-25
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentService commentService;

    @Override
    public Page<Comment> getComments(Integer curr, Integer size, Integer total) {
        Page<Comment> page = new Page<>(curr, size, total, false);
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid", 0);
        Page<Comment> rootComments =  commentService.page(page, queryWrapper);
        List<Comment> comments = rootComments.getRecords();
        List<Long> rootIds = new ArrayList<>();

        for (Comment comment : comments) {
            rootIds.add(comment.getId());
        }

        List<Comment> subComments = getSubComment(rootIds);
        comments = mergeComment(comments, subComments);
        return rootComments;
    }

    @Override
    public List<Comment> getSubComment(List<Long> rootIds) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("pid", rootIds);
        return commentService.list(queryWrapper);
    }

    private List<Comment> mergeComment(List<Comment> records, List<Comment> subComment) {
        HashMap<Long, Comment> map = new HashMap<>();

        for (Comment comment : records) {
            map.put(comment.getId(), comment);
        }

        for (Comment comment : subComment) {
            map.put(comment.getId(), comment);
        }

        List<Comment> comments = new ArrayList<>();

        for (Comment comment : map.values()) {
            if (comment.getPid() == 0) {
                comments.add(comment);
            } else {
                Comment parent = map.get(comment.getPid());
                parent.getReplies().add(comment);
            }
        }
        return comments;
    }
}
