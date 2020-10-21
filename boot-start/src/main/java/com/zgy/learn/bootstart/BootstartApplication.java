package com.zgy.learn.bootstart;

<<<<<<< HEAD
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> multiplethread
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootstartApplication {
<<<<<<< HEAD

    public static void main(String[] args) {
        SpringApplication.run(BootstartApplication.class, args);
=======
    // 日志记录器, 日志面向slf4j
    private static Logger logger = LoggerFactory.getLogger(BootstartApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BootstartApplication.class, args);
        logger.info("开始启动了....");
>>>>>>> multiplethread
    }

}
