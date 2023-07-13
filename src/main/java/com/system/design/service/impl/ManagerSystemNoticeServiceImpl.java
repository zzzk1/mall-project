package com.system.design.service.impl;

import com.system.design.common.util.RedisUtil;
import com.system.design.entity.ManagerSystemNotice;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import com.system.design.mapper.ManagerSystemNoticeMapper;
import com.system.design.service.ManagerSystemNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-04
 */
@Slf4j
@Service
public class ManagerSystemNoticeServiceImpl extends ServiceImpl<ManagerSystemNoticeMapper, ManagerSystemNotice> implements ManagerSystemNoticeService {
    @Autowired
    private ManagerSystemNoticeMapper managerSystemNoticeMapper;

    @Resource
    private RedisUtil redisUtil;

    public boolean updateStatus(List<Long> noticeIds) {
        return managerSystemNoticeMapper.updateState(noticeIds);
    }

    @Cacheable(cacheNames = "message-single", key = "'userId:' + #userId")
    @Override
    public List<ManagerSystemNoticeVo> getMessage(Date now, Long userId) {
        return managerSystemNoticeMapper.getMessage(now, userId);
    }
}
