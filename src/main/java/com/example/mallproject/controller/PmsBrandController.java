package com.example.mallproject.controller;

import com.example.mallproject.common.api.Result;
import com.example.mallproject.pojo.DO.PmsBrand;
import com.example.mallproject.service.PmsBrandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zzzk1
 */
@Api(tags = "品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService service;
    @GetMapping
    public Result<List<PmsBrand>> getAll() {
        return Result.Success(service.getAll());
    }

    @GetMapping("{name}")
    public Result<PmsBrand> getByName(@PathVariable String name) {
        return Result.Success(service.getByName(name));
    }

    @GetMapping("/id/{id}")
    public Result<PmsBrand> getById(@PathVariable Integer id) {
        return Result.Success( service.getById(id));
    }

    @PostMapping
    public Result<Integer> add(@RequestBody PmsBrand pmsBrand) {
        return Result.Success(service.add(pmsBrand));
    }

    @DeleteMapping("{name}")
    public Result<Integer> deleteByName(@PathVariable String name) {
        return Result.Success(service.deleteByName(name));
    }

    @DeleteMapping("/id/{id}")
    public Result<Integer> deleteById(@PathVariable Integer id) {
        return Result.Success(service.deleteById(id));
    }

    @PutMapping("{name}")
    public Result<Integer> updateByName(@PathVariable String name, @RequestBody PmsBrand pmsBrand) {
        return Result.Success(service.updateByName(name, pmsBrand));
    }

    @PutMapping("/id/{id}")
    public Result<Integer> updateById(@PathVariable Integer id, @RequestBody PmsBrand pmsBrand) {
        return Result.Success(service.updateById(id, pmsBrand));
    }
}
