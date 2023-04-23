package com.example.mallproject.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface IOssService {
    public String upload(InputStream inputStream, String name);
    public String upload(MultipartFile file);
}
