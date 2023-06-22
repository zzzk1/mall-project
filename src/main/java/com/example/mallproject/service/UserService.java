package com.example.mallproject.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.dto.UserDTO;
import com.example.mallproject.entity.vo.UserVO;
import com.example.mallproject.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-19
 */
public interface UserService extends IService<User> {
    Page<User> selectAll(int curr, int size, String name);
    UserVO login(UserDTO UserDTO);
    User register(UserDTO userDTO);
    User getUser(String username);

}
