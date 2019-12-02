package com.zgy.learn.bootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstartApplication.class, args);
    }

}
