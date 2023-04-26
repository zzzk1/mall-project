package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.entity.File;
import com.example.mallproject.mapper.FileMapper;
import com.example.mallproject.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-26
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
    @Autowired
    private FileService fileService;

    @Override
    public Page<File> getPage(Integer pageNum, Integer pageSize, String name) {
        Page<File> page = new Page<>(pageNum, pageSize);
        return fileService.page(page);
    }

    @Override
    public boolean save(String url) {
        File file = new File();
        file.setUrl(url);
        return fileService.save(file);
    }

    @Override
    public Boolean remove(String fileUrl) {
        QueryWrapper<File> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", fileUrl);
        return fileService.remove(queryWrapper);
    }

    @Override
    public Boolean remove(List<Integer> ids) {
        return fileService.removeByIds(ids);
    }

    @Autowired
    private FileMapper fileMapper;
    @Override
    public int save(List<String> urls) {
        return fileMapper.saveByUrls(urls);
    }

    @Override
    public List<String> getUrls(List<Integer> ids) {
        return fileMapper.getUrls(ids);
    }

}
