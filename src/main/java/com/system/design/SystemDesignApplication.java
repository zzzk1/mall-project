package com.system.design;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author zzzk1
 */
@SpringBootApplication
//@EnableApiTimeLog
@EnableCaching
public class SystemDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemDesignApplication.class, args);
    }

}
