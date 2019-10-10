package com.zgy.learn.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/11 1:30
 * @Modified by:
 */
public class MainCar {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-setting-inject.xml");
        Car c1 = (Car) ctx.getBean("car");
        Car c2 = (Car) ctx.getBean("car2");
        Car c3 = (Car) ctx.getBean("car3");
        Car c5 = (Car) ctx.getBean("car5");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println("c2==c3 : " + (c2 == c3));
        System.out.println(c2);
        System.out.println(c5);
    }
}
