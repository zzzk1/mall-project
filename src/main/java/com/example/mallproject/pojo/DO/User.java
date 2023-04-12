package com.example.mallproject.pojo.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mallproject.pojo.DO.BasePojo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_user")
public class User extends BasePojo {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id", dataType = "int", required = true)
    private int id;
    private String name;
    private String password;
}
