package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallproject.entity.FileDB;
import com.example.mallproject.mapper.FileMapper;
import com.example.mallproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-23
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileDB> implements FileService{
    @Autowired
    private FileService fileService;

    @Override
    public Boolean saveFileDB(String name, String type, long size, String url, String md5) {
        if (fileService.getFileDB(md5) != null) {
            return false;
        }
        FileDB saveFile = new FileDB();
        saveFile.setName(name);
        saveFile.setType(type);
        saveFile.setSize(size / 1024);
        saveFile.setUrl(url);
        saveFile.setMd5(md5);
        return fileService.saveOrUpdate(saveFile);
    }

    @Autowired
    private FileMapper fileMapper;
    @Override
    public FileDB getFileDB(String md5) {
        return fileMapper.getFileDB(md5);
    }
}
