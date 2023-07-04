package com.system.design.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zzzk1
 */
@Data
public class ManagerSystemNoticeDTO implements Serializable {
    /**
     * 发给哪些用户：单用户 single；全体用户 all，vip 用户
     */
    private String type;
    /**
     * 接受通知的用户的 ID，如果 type 为单用户，那么 recipient 为该用户的 ID;否则 recipient 为 0
     */
    private Long recipientId;
    /**
     * 发布时间
     */
//    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime publishTime;
}
