package com.example.mallproject.pojo.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mallproject.pojo.DO.BasePojo;
import lombok.Data;

@Data
@TableName("t_role")
public class Role extends BasePojo {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String info;
}
