package com.system.design.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("t_user_system_notice")
public class UserSystemNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_notice_id", type = IdType.AUTO)
    private Long userNoticeId;

    /**
     * 是否已读	
     */
    private Boolean state;

    /**
     * 系统通知的 ID	
     */
    private Long systemNoticeId;

    /**
     * 接受通知的用户的 ID	
     */
    private Long recipientId;

    /**
     * 拉取通知的时间	
     */
    private LocalDateTime pullTime;


}
