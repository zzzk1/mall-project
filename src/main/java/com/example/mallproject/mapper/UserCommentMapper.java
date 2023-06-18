package com.example.mallproject.mapper;

import com.example.mallproject.entity.UserComment;
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
 * @since 2023-06-17
 */
@Mapper
public interface UserCommentMapper extends BaseMapper<UserComment> {
    List<Long> getList(@Param("userId") Long userId);
}
