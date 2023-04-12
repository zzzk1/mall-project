package com.example.mallproject.pojo.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

@Data
public class BasePojo {
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间", dataType = "Integer", required = true)
    private Date createTime;
    @ApiModelProperty(value = "创建时间", dataType = "Integer", required = true)
    @TableField(value = "update_time")
    private Date updateTime;
    private int deleted;
}
