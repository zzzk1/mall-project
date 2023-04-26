package com.example.mallproject.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-26
 */
public interface FileService extends IService<File> {

    boolean save(String url);

    Boolean remove(String fileUrl);

    Boolean remove(List<Integer> ids);

    int save(List<String> urls);

    Page<File> getPage(Integer pageNum, Integer pageSize, String name);

    List<String> getUrls(List<Integer> ids);
}
