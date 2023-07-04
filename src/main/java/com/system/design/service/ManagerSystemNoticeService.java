package com.system.design.service;

import com.system.design.entity.ManagerSystemNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-04
 */
public interface ManagerSystemNoticeService extends IService<ManagerSystemNotice> {
    ManagerSystemNoticeVo send2AllUser(LocalDateTime time);
    ManagerSystemNoticeVo send2User(@Param("recipient_id") Long userId, @Param("type") String userType, @Param("publish_time") LocalDateTime time);
}
