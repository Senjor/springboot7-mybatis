package com.zhiyou.springboot7mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// mapper 接口类扫描包配置
@MapperScan("com.zhiyou.springboot7mybatis.dao")
public class Springboot7MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot7MybatisApplication.class, args);
    }

}
