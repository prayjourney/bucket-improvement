package com.zgy.learn.dubbobootconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboBootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboBootConsumerApplication.class, args);
    }

}
