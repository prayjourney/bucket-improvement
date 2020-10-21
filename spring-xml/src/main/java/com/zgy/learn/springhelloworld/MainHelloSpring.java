package com.zgy.learn.springhelloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription: Spring HelloWorld！
 * @Date: Created in 2019/10/10 22:31
 * @Modified by:
 * @SoruceAnalyse: https://my.oschina.net/klausprince/blog/1791357
 *                 https://my.oschina.net/klausprince/blog/1793623
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
