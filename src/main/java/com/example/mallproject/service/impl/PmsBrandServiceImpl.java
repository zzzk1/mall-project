package com.example.mallproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mallproject.mapper.PmsBrandMapper;
import com.example.mallproject.pojo.DO.PmsBrand;
import com.example.mallproject.pojo.DO.User;
import com.example.mallproject.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper mapper;

    @Override
    public List<PmsBrand> getAll() {
        QueryWrapper<PmsBrand> query = new QueryWrapper<>();
        return mapper.selectList(query);
    }

    @Override
    public PmsBrand getById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public PmsBrand getByName(String name) {
        QueryWrapper<PmsBrand> query = new QueryWrapper<>();
        query.eq("name", name);
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand = mapper.selectOne(query);
        return pmsBrand;
    }

    @Override
    public int add(PmsBrand pmsBrand) {
        return mapper.insert(pmsBrand);
    }

    @Override
    public int deleteByName(String name) {
        QueryWrapper<PmsBrand> query = new QueryWrapper<>();
        query.eq("name", name);
        return mapper.delete(query);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public int updateByName(String name, PmsBrand pmsBrand) {
        QueryWrapper<PmsBrand> query = new QueryWrapper<>();
        query.eq("name", name);
        return mapper.update(pmsBrand, query);
    }

    @Override
    public int updateById(int id, PmsBrand pmsBrand) {
        QueryWrapper<PmsBrand> query = new QueryWrapper<>();
        query.eq("id", id);
        return mapper.update(pmsBrand, query);
    }
}
