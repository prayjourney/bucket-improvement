package com.zgy.learn.config;

import com.zgy.learn.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/27 16:49
 * @Modified by:
 */
@Configuration  // 表示这是一个注解配置的类，作用等于配置的xml文件
@ComponentScan(value = "com.zgy.learn")  // 包扫描，指定位置, 指定com.zgy.learn
public class MainConfig {

    // 给容器返回一个bean, 类型是Person，默认的名字是方法名，首字母小写
//    @Bean
//    public Person person(){
//        return new Person("张三",25);
//
//    }
    @Bean(name = "helloperson")
    public Person person01() {
        return new Person("Lili", 22);
    }
}
