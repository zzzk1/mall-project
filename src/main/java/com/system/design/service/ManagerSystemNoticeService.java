package com.system.design.service;

import com.system.design.entity.ManagerSystemNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.system.design.entity.vo.ManagerSystemNoticeVo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-04
 */
public interface ManagerSystemNoticeService extends IService<ManagerSystemNotice> {
    List<ManagerSystemNoticeVo> getMessage(Date now, Long userId);
}
