package com.system.design.controller;

import com.system.design.common.api.Result;
import com.system.design.common.util.ThreadLocalUtil;
import com.system.design.entity.User;
import com.system.design.service.MessageQueueService;
import com.system.design.service.PullNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private PullNoticeService pullNoticeService;
    @Autowired
    private MessageQueueService messageQueueService;

    @GetMapping
    public Result<List<HashMap<Long, MenuSelectionManager>>> getMsg() {
        pullNoticeService.pullSingleUserMsg();
        messageQueueService.putMsgFromCache();
        User user = (User) ThreadLocalUtil.get("userInfo");
        Long userId = user.getUserId();

        HashMap<Long, MenuSelectionManager> allMsg = messageQueueService.sentMessage("all");
        HashMap<Long, MenuSelectionManager> singleMsg = messageQueueService.sentMessage("single");
        List<HashMap<Long, MenuSelectionManager>> list = new ArrayList<>();
        list.add(allMsg);
        list.add(singleMsg);
        return Result.success(list);
    }
}
