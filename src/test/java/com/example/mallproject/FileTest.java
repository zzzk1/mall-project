package com.example.mallproject;

import com.example.mallproject.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileTest {
    @Autowired
    private FileService fileService;
    @Test
    void delete() {
        System.out.println(fileService.deleteFileDB(1));
    }
}
