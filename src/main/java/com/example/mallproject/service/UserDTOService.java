package com.example.mallproject.service;

import java.util.List;

/**
 * @author zzzk1
 */
public interface UserDTOService {

    List<Integer> getLoginUserMenuIds(String role);
}
