package com.system.design.mapper;

import com.system.design.entity.ManagerSystemNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    List<ManagerSystemNoticeVo> getMessage(@Param("publish_time")Date now, @Param("recipient_id") Long userId);
    boolean updateState(@Param("ids") List<Long> ids);
}
