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
    void insert() {
        List<String> urls = new ArrayList<>();
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
