package com.system.design.service.impl;

import com.system.design.entity.Log;
import com.system.design.entity.dto.LogDTO;
import com.system.design.mapper.LogMapper;
import com.system.design.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-11
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {
    @Autowired
    private LogService logService;

    @Override
    public boolean saveLog(LogDTO logDTO) {
        Log log = logDtoObject2Log(logDTO);
        return logService.save(log);
    }

    private Log logDtoObject2Log(LogDTO logDTO) {
        Log userLog = new Log();

        return userLog;
    }

}
