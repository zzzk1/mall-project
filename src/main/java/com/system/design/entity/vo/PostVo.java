package com.system.design.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PostVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long postId;

    private String title;

    private String context;

    private Integer likes;

    private Integer views;

    private Date createTime;

    private Date updateTime;

    private Long userId;
}
