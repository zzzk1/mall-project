package com.example.mallproject.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User extends BasePojo{
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String password;
}
