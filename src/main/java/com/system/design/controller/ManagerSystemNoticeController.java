package com.system.design.controller;


import com.system.design.entity.dto.ManagerSystemNoticeDTO;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import com.system.design.service.ManagerSystemNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-04
 */
@RestController
@RequestMapping("/manager-system-notice")
public class ManagerSystemNoticeController {
    @Autowired
    private ManagerSystemNoticeService managerSystemNoticeService;

    @GetMapping("/all")
    public ManagerSystemNoticeVo send2AllUser(@RequestBody LocalDateTime time) {
        if (time == null) {
            time = LocalDateTime.now();
        }
        return managerSystemNoticeService.send2AllUser(time);
    }

    @GetMapping("/single")
    public ManagerSystemNoticeVo send2User(@RequestBody ManagerSystemNoticeDTO managerSystemNoticeDTO) {
        return managerSystemNoticeService.send2User(managerSystemNoticeDTO);
    }
}
