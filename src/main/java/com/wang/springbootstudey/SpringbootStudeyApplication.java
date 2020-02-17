package com.wang.springbootstudey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.wang.springbootstudey.generator"})
public class SpringbootStudeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudeyApplication.class, args);
    }

}
