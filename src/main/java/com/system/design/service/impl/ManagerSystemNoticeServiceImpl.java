package com.system.design.service.impl;

import com.system.design.common.api.RedisApi;
import com.system.design.entity.ManagerSystemNotice;
import com.system.design.entity.dto.ManagerSystemNoticeDTO;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import com.system.design.mapper.ManagerSystemNoticeMapper;
import com.system.design.service.ManagerSystemNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-04
 */

@Service
public class ManagerSystemNoticeServiceImpl extends ServiceImpl<ManagerSystemNoticeMapper, ManagerSystemNotice> implements ManagerSystemNoticeService {
    @Autowired
    private ManagerSystemNoticeMapper managerSystemNoticeMapper;

    @Resource
    private RedisApi redisApi;

    @Cacheable(cacheNames = "TotalMsg", key = "'publish_time:' + #time")
    @Override
    public ManagerSystemNoticeVo send2AllUser(LocalDateTime time) {
        return managerSystemNoticeMapper.send2AllUser(time);
    }

    @Cacheable(cacheNames = "singleMsg", key = "'userId-' + #managerSystemNoticeDTO.getRecipientId()")
    @Override
    public ManagerSystemNoticeVo send2User(ManagerSystemNoticeDTO managerSystemNoticeDTO) {
        Long userId = managerSystemNoticeDTO.getRecipientId();
        String  userType = managerSystemNoticeDTO.getType();
        LocalDateTime time = managerSystemNoticeDTO.getPublishTime();
        return managerSystemNoticeMapper.send2User(userId, userType, time);
    }
}