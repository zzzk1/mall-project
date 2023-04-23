package com.example.mallproject.controller;

import com.example.mallproject.common.api.Result;
import com.example.mallproject.service.IOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zzzk1
 */
@RestController
@RequestMapping("/ossController")
public class OssController {
    @Autowired
    private IOssService ossService;

    @PostMapping(value = "/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file, HttpServletRequest req)  {
        return Result.Success(ossService.upload(file), "上传成功");
    }
}
