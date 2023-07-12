package com.system.design.entity;

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
 * @since 2023-07-11
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long logId;
    private String operator;
    private String context;
    private String bizNo;
    private Date operateDate;
    private String operationType;
}
