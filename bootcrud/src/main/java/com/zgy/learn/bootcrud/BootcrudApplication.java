package com.zgy.learn.bootcrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootcrudApplication {
    private static Logger logger = LoggerFactory.getLogger(BootcrudApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BootcrudApplication.class, args);
        logger.info("spring boot crud 项目开始启动了！");
    }

}
