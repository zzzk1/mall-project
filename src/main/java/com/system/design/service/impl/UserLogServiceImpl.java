package com.system.design.service.impl;

import com.system.design.entity.UserLogDO;
import com.system.design.entity.dto.UserLogDTO;
import com.system.design.mapper.UserLogMapper;
import com.system.design.service.UserLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-07
 */
@Service
public class UserLogServiceImpl extends ServiceImpl<UserLogMapper, UserLogDO> implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public boolean addSysLog(UserLogDTO userLogDTO) {
        UserLogDO userLogDO = new UserLogDO();
        userLogDO.setModuleCode(userLogDTO.getModuleCode());
        userLogDO.setType(userLogDTO.getType());
        userLogDO.setTitle(userLogDTO.getTitle());
        userLogDO.setOperatorId(userLogDTO.getOperatorId());
        userLogDO.setOperateTime(userLogDTO.getOperateTime());
        userLogDO.setContent(userLogDTO.getContent());

        return userLogMapper.insert(userLogDO) > 0;
    }
}
