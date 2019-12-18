package com.zgy.learn.bootjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: renjiaxin
 * @Despcription: https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter
 * @Date: Created in 2019/12/19 1:28
 * @Modified by:
 */
@Configuration
public class DruidConfig {
    // 配置Druid数据源， 并且配置具体详细参数，让其起作用
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

}
