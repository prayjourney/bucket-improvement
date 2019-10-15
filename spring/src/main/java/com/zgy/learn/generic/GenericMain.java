package com.zgy.learn.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/16 0:39
 * @Modified by:
 */
public class GenericMain {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("spring-generic-inject.xml");
        UserService us = (UserService)context.getBean("uservice");
        us.add();
    }
}
