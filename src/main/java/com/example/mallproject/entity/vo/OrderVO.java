package com.example.mallproject.entity.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderVO {
    private String spuName;

    private String address;

    private LocalDateTime createTime;

    private Integer amount;

    private Integer finished;

    private Long uuid;
}
