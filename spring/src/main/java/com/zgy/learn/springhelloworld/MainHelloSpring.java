package com.zgy.learn.springhelloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription: Spring HelloWorld！
 * @Date: Created in 2019/10/10 22:31
 * @Modified by:
 */
public class MainHelloSpring {

    public static void main(String[] args) {
        // 1.创建Spring IOC容器
        ApplicationContext act = new ClassPathXmlApplicationContext("spring-helloworld.xml");
        // 2.从容器中获取Bean
        HelloSpring hs = (HelloSpring) act.getBean("zhangsan");
        // 3.调用方法
        System.out.println(hs.toString());
    }
}
