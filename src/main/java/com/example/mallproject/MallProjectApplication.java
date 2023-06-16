package com.example.mallproject;

import com.example.mallproject.common.log.EnableApiLog;
import com.example.mallproject.common.log.EnableApiTimeLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableApiTimeLog
@EnableApiLog
public class MallProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProjectApplication.class, args);
    }

}
