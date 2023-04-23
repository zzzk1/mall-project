package com.example.mallproject.mapper;

import com.example.mallproject.entity.FileDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-23
 */
@Mapper
public interface FileMapper extends BaseMapper<FileDB> {
    @Select("select * from sys_file where md5=#{md5}")
    public FileDB getFileDB(String md5);
}
