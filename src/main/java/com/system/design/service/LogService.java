package com.system.design.service;

import com.system.design.entity.Log;
import com.baomidou.mybatisplus.extension.service.IService;
import com.system.design.entity.dto.LogDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-11
 */
public interface LogService extends IService<Log> {
    boolean saveLog(LogDTO logDTO);
}
