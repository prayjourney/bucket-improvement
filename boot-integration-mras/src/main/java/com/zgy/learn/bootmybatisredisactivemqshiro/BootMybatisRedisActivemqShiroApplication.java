package com.zgy.learn.bootmybatisredisactivemqshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

// 扫描Mapper包
@MapperScan(basePackages = {"com.zgy.learn.bootmybatisredisactivemq.mapper"})
@SpringBootApplication
// 开启JMS支持，此处是ActiveMq
@EnableJms
public class BootMybatisRedisActivemqShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootMybatisRedisActivemqShiroApplication.class, args);
    }

}
