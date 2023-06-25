package com.example.mallproject.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzzk1
 * @since 2023-06-25
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    Page<Comment> getComments(Page<Comment> page, @Param(Constants.WRAPPER)Wrapper<Comment> wrapper);
}
