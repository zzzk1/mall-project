package com.system.design.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PostVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long postId;

    private String title;

    private String context;

    private Integer likes;

    private Integer views;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long userId;
}
