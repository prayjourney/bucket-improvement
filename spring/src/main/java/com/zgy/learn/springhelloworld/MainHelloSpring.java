package com.zgy.learn.springhelloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/10 22:31
 * @Modified by:
 */
public class MainHelloSpring {

    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("spring-helloworld.xml");
        HelloSpring hs = (HelloSpring) act.getBean("zhangsan");
        System.out.println(hs.toString());
    }
}
