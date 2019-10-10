package com.zgy.learn.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/11 1:47
 * @Modified by:
 */
public class MainSuperStar {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-constructor-inject.xml");
        SuperStar s1 = (SuperStar) ctx.getBean("liuyifei");
        SuperStar s2 = (SuperStar) ctx.getBean("zhangsan");
        SuperStar s3 = (SuperStar) ctx.getBean("huge");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
