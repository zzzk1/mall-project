package com.example.mallproject.controller;


import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.utils.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    OssUtils ossUtils;

    @PostMapping("uploadOneFile")
    public Result<String> uploadFile(@RequestBody MultipartFile file) throws Exception {
        //返回上传oss的url
        return Result.Success(ossUtils.uploadOneFile(file));
    }

    @PostMapping("uploadArrayFile")
    public Result<List<String>> uploadArrayFile(@RequestBody MultipartFile[] files) {
        //返回上传oss的url
        return Result.Success(ossUtils.uploadArrayFile(files));
    }

    @PostMapping("deleteFile")
    public Result<Boolean> deleteFile(@RequestParam String fileUrl) {
        //返回是否删除成功
        return Result.Success(ossUtils.deleteFile(fileUrl));
    }
}
