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
        Song s1 = (Song) ctx.getBean("qinghuaci");
        Song s2 = (Song) ctx.getBean("faruxue");
        Song s3 = (Song) ctx.getBean("qingmingyushang");
        Song s4 = (Song) ctx.getBean("juejiang");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        Singer jay = (Singer) ctx.getBean("jay");
        jay.getAllSongs();

        SuperSingers singers2008 = (SuperSingers) ctx.getBean("superSingers2008");
        System.out.println(singers2008.toString());

        SuperSingers2 singers2010 = (SuperSingers2) ctx.getBean("superSingers2010");
        System.out.println(singers2010.toString());
    }
}
