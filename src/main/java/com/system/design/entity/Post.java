package com.system.design.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "post_id", type = IdType.AUTO)
    private Long postId;

    private String title;

    private String context;

    private Integer likes;

    private Integer views;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private Long userId;


}
