package com.example.mallproject;

import com.example.mallproject.mapper.FileMapper;
import com.example.mallproject.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FileTest {
    @Autowired
    private FileService fileService;

    @Autowired(required = false)
    private FileMapper fileMapper;
    @Test
    void insertInto() {
        List<String> urls = new ArrayList<>();
        urls.add("http://zzzk1-mall-project.oss-cn-hongkong.aliyuncs.com/2023/04/266d7cb57f5cf24803ba2a36ed6833a9c1Google 帐号-009-TH5JyKLU1DhIrOWVbnLRgWxsEUdCf-EjXLPuojsYxx0pM=s250.png");
        urls.add("http://zzzk1-mall-project.oss-cn-hongkong.aliyuncs.com/2023/04/269a043a0b509f46939efe069265c31a26Google 帐号-008-6vhmBnpP6gfR7MNU5TCVnrbW2ct2K3s0I2LhKBzLoq0wg=s250.png");
        fileMapper.saveByUrls(urls);
        System.out.println();
    }

    @Test
    void getByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(22);
        ids.add(21);
        ids.add(19);
        ids.add(20);
        fileMapper.getUrls(ids);
    }
}
