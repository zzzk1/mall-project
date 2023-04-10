package com.example.mallproject.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.util.Date;

@Data
public class BasePojo {
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "update_time")
    private Date updateTime;
    private int deleted;
}
