package com.zgy.learn.config;

import com.zgy.learn.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: renjiaxin
 * @Despcription: 各种定义bean的方式
 * @Date: Created in 2019/12/28 18:55
 * @Modified by:
 */
@Configuration
public class BeanDefineConfig {
    // 普通的bean定义方式
    @Bean(value = "guanyu01")
    public Person getPerson() {
        return new Person("关羽", 38);
    }

}
