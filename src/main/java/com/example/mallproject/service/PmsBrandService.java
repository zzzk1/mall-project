package com.example.mallproject.service;

import com.example.mallproject.pojo.DO.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> getAll();
    PmsBrand getById(int id);
    PmsBrand getByName(String name);
    int add(PmsBrand user);
    int deleteByName(String name);
    int deleteById(int id);
    int updateByName(String name, PmsBrand brand);
    int updateById(int id, PmsBrand brand);
}
