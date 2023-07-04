package com.system.design.mapper;

import com.system.design.entity.ManagerSystemNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-04
 */
@Mapper
public interface ManagerSystemNoticeMapper extends BaseMapper<ManagerSystemNotice> {
    ManagerSystemNoticeVo send2AllUser(@Param("time") LocalDateTime time);
    ManagerSystemNoticeVo send2User(@Param("recipient_id") Long userId, @Param("type") String userType, @Param("publish_time") LocalDateTime time);
}
