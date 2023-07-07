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
@TableName("user_log")
public class UserLogDO implements Serializable {

    private static
    final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String moduleCode;

    private Integer type;

    private String title;

    private Long operatorId;

    private Date operateTime;

    private String content;


}
