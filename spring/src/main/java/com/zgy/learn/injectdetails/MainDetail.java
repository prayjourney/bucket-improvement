package com.zgy.learn.injectdetails;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/11 2:51
 * @Modified by:
 */
public class MainDetail {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-inject-details.xml");
        Poet p1 = (Poet) ctx.getBean("fangwenshan");
        Poet p2 = (Poet) ctx.getBean("xusong");
        Poet p3 = (Poet) ctx.getBean("lanxiaoxie");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
