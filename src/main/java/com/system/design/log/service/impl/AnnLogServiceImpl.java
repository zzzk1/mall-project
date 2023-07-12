package com.system.design.log.service.impl;

import com.system.design.entity.Log;
import com.system.design.entity.dto.LogDTO;
import com.system.design.log.service.AnnoLogService;
import com.system.design.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnnLogServiceImpl implements AnnoLogService {
    @Autowired
    private LogService logService;

    @Override
    public Boolean saveLog(LogDTO logDTO) {
        log.info(logDTO.toString());
        Log log = createLog(logDTO);
        return logService.save(log);
    }

    private Log createLog(LogDTO logDTO) {
        Log log = new Log();
        log.setOperator(logDTO.getOperator());
        log.setOperateDate(logDTO.getOperateDate());
        log.setContext(logDTO.getContext());
        log.setBizNo(logDTO.getBizNo());
        log.setOperationType(logDTO.getOperationType());
        return log;
    }
}
