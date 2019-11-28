package com.dsql;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.dsql.mapper")
@SpringBootApplication
public class DsqlApplication {


    public static void main(String[] args) {
        SpringApplication.run(DsqlApplication.class, args);
    }

}
