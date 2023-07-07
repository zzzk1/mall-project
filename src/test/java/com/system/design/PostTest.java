package com.system.design;

import com.system.design.entity.Post;
import com.system.design.entity.vo.PostVo;
import com.system.design.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class PostTest {
    @Autowired
    private PostService postService;

    @Test
    void getHotPost() {
        List<PostVo> posts = postService.getHotPost();
    }
}
