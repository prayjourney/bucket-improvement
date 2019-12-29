package com.zgy.learn.config;

import com.zgy.learn.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/29 23:52
 * @Modified by:
 */
@Configuration
public class MainConfigOfPropertyValue {

    @Bean
    public Person person() {
        return new Person();
    }


}
