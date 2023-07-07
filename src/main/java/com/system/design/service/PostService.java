package com.system.design.service;

import com.system.design.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.system.design.entity.vo.PostVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-07
 */
public interface PostService extends IService<Post> {
    List<PostVo> getHotPost();
}
