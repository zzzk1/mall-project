package com.system.design.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.system.design.entity.UserLogDO;
import com.system.design.entity.dto.UserLogDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-07
 */
public interface UserLogService extends IService<UserLogDO> {
    boolean addSysLog(UserLogDTO userLogDTO);
}
