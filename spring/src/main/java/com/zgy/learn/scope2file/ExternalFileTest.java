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

        Human h1 = (Human)context.getBean("beijingren1");
        System.out.println(h1.toString());
        Human h2 = (Human)context.getBean("beijingren2");
        System.out.println(h2.toString());
        Human h3 = (Human)context.getBean("beijingren3");
        System.out.println(h3.toString());

        Boy boy2 = (Boy)context.getBean("boy2");
        System.out.println(boy2.toString());

        Boy boy3 = (Boy)context.getBean("boy3");
        System.out.println(boy3.toString());

        Boy sb = (Boy)context.getBean("superBoy");
        System.out.println(sb);

    }
}
