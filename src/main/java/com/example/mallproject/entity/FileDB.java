package com.example.mallproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-23
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_file")
public class FileDB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 下载链接
     */
    private String url;

    /**
     * 是否删除
     */
    private Integer delete;

    private Integer enable;

    /**
     * md5
     */
    private String md5;


}
