package com.example.mallproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mallproject.pojo.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<user> {
}
