package com.example.mallproject.service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mallproject.entity.FileDB;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-23
 */
public interface FileService extends IService<FileDB> {
    Boolean saveFileDB(String name, String type, long size, String url, String md5);
    FileDB getFileDB(String md5);
    int deleteFileDB(Integer id);
    Page<FileDB> getPage(int pageNum, int pageSize, String name);
}
