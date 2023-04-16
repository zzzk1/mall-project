package com.example.mallproject.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */
public interface UserService extends IService<User> {
    Page<User> selectAll(int curr, int size);
    User getUserAndRoleById(long id);
    User login(User user);
    boolean enroll(User user);
}
