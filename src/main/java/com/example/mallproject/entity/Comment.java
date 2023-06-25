package com.example.mallproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zzzk1
 * @since 2023-06-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String content;

    private LocalDateTime createTime;

    private Integer likes;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 帖子id
     */
    private Long postId;

    /**
     * 回复对象
     */
    private Long toUserId;

    private Long pid;

    @TableField(exist = false)
    private List<Comment> replies =  new ArrayList<>();
}
