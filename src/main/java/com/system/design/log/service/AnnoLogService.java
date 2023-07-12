package com.system.design.log.service;

import com.system.design.entity.dto.LogDTO;

public interface AnnoLogService {
    Boolean saveLog(LogDTO logDTO);
}
