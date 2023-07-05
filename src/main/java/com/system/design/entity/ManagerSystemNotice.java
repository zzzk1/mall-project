package com.system.design.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_manager_system_notice")
public class ManagerSystemNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "system_notice_id", type = IdType.AUTO)
    private Long systemNoticeId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发给哪些用户：单用户 single；全体用户 all，vip 用户
     */
    private String type;

    /**
     * 是否已被拉取过，如果已经拉取过，就无需再次拉取
     */
    private Boolean state;

    /**
     * 接受通知的用户的 ID，如果 type 为单用户，那么 recipient 为该用户的 ID;否则 recipient 为 0
     */
    private Long recipientId;

    /**
     * 发布通知的管理员 ID
     */
    private Long managerId;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime publishTime;


}
