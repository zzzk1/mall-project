package com.system.design.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.system.design.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.system.design.entity.vo.PostVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-07
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {
    List<PostVo> getHotPost();
}
