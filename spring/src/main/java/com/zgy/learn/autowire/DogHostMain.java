package com.zgy.learn.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/14 1:07
 * @Modified by:
 */
public class DogHostMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-autowire.xml");
        DogHost xiaoming = (DogHost) context.getBean("xiaoming");
        PastoralDog xiaohuang = (PastoralDog) context.getBean("xiaohuang");
        PastoralDog xiaohei = (PastoralDog) context.getBean("xiaohei");
        PastoralDog xiaoMmm = (PastoralDog) context.getBean("xiaoMmm");
        System.out.println(xiaohuang);
        System.out.println(xiaoming);
        System.out.println(xiaohei);
        System.out.println(xiaoMmm);
    }
}
