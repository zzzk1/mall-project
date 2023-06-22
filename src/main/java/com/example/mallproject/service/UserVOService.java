package com.example.mallproject.service;

import com.example.mallproject.entity.vo.UserVO;
import com.example.mallproject.entity.User;

import java.util.List;

/**
 * @author zzzk1
 */
public interface UserVOService {

    List<Integer> getLoginUserMenuIds(String role);
    void setLoginUserInfo(User user, UserVO userVO, String token);
}
