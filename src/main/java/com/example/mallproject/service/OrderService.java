package com.example.mallproject.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-19
 */
public interface OrderService extends IService<Order> {
    Page<Order> selectAll(int pageNum, int pageSize, String username);
}
