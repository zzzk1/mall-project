package com.example.mallproject.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.entity.FileDB;
import com.example.mallproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-23
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value(value ="${files.upload.path}")
    private String fileUploadPath;

    @Autowired
    private FileService fileService;
    @PostMapping("/upload")
    public Result<String> upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();

        // 定义一个文件唯一的标识码
        String uuid = IdUtil.fastSimpleUUID();
        String fileUUID = uuid + StrUtil.DOT + type;

        File uploadFile = new File(fileUploadPath + fileUUID);
        // 判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        File parentFile = uploadFile.getParentFile();
        if(!parentFile.exists()) {
            parentFile.mkdirs();
        }

        String url;
        // 获取文件的md5
        String md5 = SecureUtil.md5(file.getInputStream());
        // 从数据库查询是否存在相同的记录
        FileDB dbFiles = fileService.getFileDB(md5);
        if (dbFiles != null) { // 文件已存在
            url = dbFiles.getUrl();
            return Result.Failed(url, "文件已存在");
        } else {
            // 上传文件到磁盘
            // 数据库若不存在重复文件，则不删除刚才上传的文件
            url = "http://localhost:9090/file/" + fileUUID;
        }
        file.transferTo(uploadFile);
        fileService.saveFileDB(originalFilename, type, size / 1024, url, md5);
        return Result.Success(null, "上传成功");
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteFileDB(@PathVariable Integer id) {
        if (fileService.deleteFileDB(id) == 1) {
            return Result.Success(1, "删除成功");
        } else {
            return Result.Failed(0,"删除失败");
        }
    }

    @PostMapping("/update")
    public Result<Boolean> updateFileDB(@RequestBody FileDB file) {
        return Result.Success(fileService.updateById(file));
    }

    @PostMapping("/del/batch")
    public Result<Integer> deleteBatch(@RequestBody List<Integer> ids) {
        // select * from sys_file where id in (id,id,id...)
        for (Integer id : ids) {
            fileService.deleteFileDB(id);
        }
        return Result.Success(1, "批量删除成功");
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String name) {
        return Result.Success(fileService.getPage(pageNum, pageSize, name));
    }
}
