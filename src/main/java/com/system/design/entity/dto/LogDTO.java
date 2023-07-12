package com.system.design.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LogDTO {
    private Long logId;
    private String operator;
    private String context;
    private String bizNo;
    private Date operateDate;
    private String operationType;
}
