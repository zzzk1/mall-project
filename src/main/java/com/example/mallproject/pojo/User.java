package com.example.mallproject.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String password;
    private Date create_time;
    private Date update_time;
    private int deleted;
}
