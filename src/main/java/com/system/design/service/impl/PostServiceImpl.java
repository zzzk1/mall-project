package com.system.design.service.impl;

import com.system.design.entity.Post;
import com.system.design.entity.vo.PostVo;
import com.system.design.mapper.PostMapper;
import com.system.design.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-07
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<PostVo> getHotPost() {
        return postMapper.getHotPost();
    }
}
