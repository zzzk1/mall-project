package com.example.mallproject.controller;


import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.utils.FileDBUtil;
import com.example.mallproject.entity.FileDB;
import com.example.mallproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private FileService fileService;
    @Autowired
    private FileDBUtil fileDBUtil;
    @PostMapping("/upload")
    public Result<String> upload(@RequestParam MultipartFile file) throws IOException {
        String url = fileDBUtil.upload(file);
        return Result.Success(url, "上传成功");
    }

    @GetMapping("/{fileUUID}")
    public void download(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {
        fileDBUtil.downLoad(fileUUID, response);
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
