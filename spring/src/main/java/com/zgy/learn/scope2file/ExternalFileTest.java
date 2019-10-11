package com.zgy.learn.scope2file;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/11 22:54
 * @Modified by:
 */
public class ExternalFileTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-scope-and-externalfile.xml");
        Boy zgy = (Boy)context.getBean("zgy");
        System.out.println(zgy.toString());
    }
}
