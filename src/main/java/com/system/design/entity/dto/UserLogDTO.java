package com.system.design.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserLogDTO implements Serializable {

    private Long id;

    private String moduleCode;

    private Integer type;

    private String title;

    private Long operatorId;

    private Date operateTime;

    private String content;

}
