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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Cacheable(cacheNames = "single-user-msg", key = "'userId-' + #userId")
    @Override
    public Map<Long, ManagerSystemNoticeVo> send2User(Long userId, LocalDateTime time) {
        Map<Long, ManagerSystemNoticeVo> info;
        info = managerSystemNoticeMapper.send2User(userId, time);
        return info;
    }

    @Cacheable(cacheNames = "all-user-msg", key = "'push-' + #time", unless="#result == null")
    @Override
    public Map<Long, ManagerSystemNoticeVo> send2AllUser(LocalDateTime time) {
        Map<Long, ManagerSystemNoticeVo> info;
        info = managerSystemNoticeMapper.send2AllUser(time);
        if (info.size() == 0) {
            log.info(String.valueOf(time));
            log.info("暂时没有新的发送给全体的消息");
            return null;
        }
        List<Long> ids = new ArrayList<>(info.size());
        ids.addAll(info.keySet());

        updateStatus(ids);
        return info;
    }

    public boolean updateStatus(List<Long> noticeIds) {
        return managerSystemNoticeMapper.updateState(noticeIds);
    }
}
