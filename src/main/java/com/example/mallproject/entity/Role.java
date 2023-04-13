package com.example.mallproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String info;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleted;

    @TableField(exist = false)
    private List<User> users;

    @TableField(exist = false)
    private List<Permission> permissions;
}
