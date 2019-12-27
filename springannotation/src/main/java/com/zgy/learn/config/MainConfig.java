package com.zgy.learn.config;

import com.zgy.learn.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/27 16:49
 * @Modified by:
 */
@Configuration  // 表示这是一个注解配置的类，作用等于配置的xml文件
@ComponentScan(value = "com.zgy.learn", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
})  // 包扫描，指定位置, 指定com.zgy.learn
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
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
