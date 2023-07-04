package com.system.design.service.impl;

import com.system.design.entity.ManagerSystemNotice;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import com.system.design.mapper.ManagerSystemNoticeMapper;
import com.system.design.service.ManagerSystemNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ManagerSystemNoticeVo send2AllUser(LocalDateTime time) {
        return managerSystemNoticeMapper.send2AllUser(time);
    }

    @Override
    public ManagerSystemNoticeVo send2User(Long userId, String userType, LocalDateTime time) {
        return managerSystemNoticeMapper.send2User(userId, userType, time);
    }
}
