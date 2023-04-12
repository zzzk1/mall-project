package com.example.mallproject.pojo.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pms_brand")
public class PmsBrand {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String logo;
    private String description;
    int deleted;
}
