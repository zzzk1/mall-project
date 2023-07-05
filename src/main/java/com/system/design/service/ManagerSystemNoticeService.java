package com.system.design.service;

import com.system.design.entity.ManagerSystemNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.system.design.entity.dto.ManagerSystemNoticeDTO;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-04
 */
public interface ManagerSystemNoticeService extends IService<ManagerSystemNotice> {

    Map<Long, ManagerSystemNoticeVo> send2User(Long userId, LocalDateTime time);

    Map<Long, ManagerSystemNoticeVo> send2AllUser(LocalDateTime time);
}
