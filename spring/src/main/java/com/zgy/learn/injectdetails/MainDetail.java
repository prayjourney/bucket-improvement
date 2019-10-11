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
        // 1.新建Spring容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-inject-details.xml");
        // 2.通过容器获得对象
        Poet p1 = (Poet) ctx.getBean("fangwenshan");
        // 3.独享的操作
        Poet p3 = (Poet) ctx.getBean("lanxiaoxie");

        // 处理特殊字符
        Poet p2 = (Poet) ctx.getBean("xusong");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // 引用bean
        Song s1 = (Song) ctx.getBean("qinghuaci");
        Song s2 = (Song) ctx.getBean("faruxue");
        Song s3 = (Song) ctx.getBean("qingmingyushang");
        // 内部bean
        Song s4 = (Song) ctx.getBean("juejiang");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        // 测试list注入
        Singer jay = (Singer) ctx.getBean("jay");
        jay.getAllSongs();

        // 测试map注入
        SuperSingers singers2008 = (SuperSingers) ctx.getBean("superSingers2008");
        System.out.println(singers2008.toString());

        // 测试map注入
        SuperSingers2 singers2010 = (SuperSingers2) ctx.getBean("superSingers2010");
        System.out.println(singers2010.toString());

        // 测试null
        Song songOld = (Song)ctx.getBean("null4Song");
        System.out.println(songOld);

        // 测试级联属性
        // Song song4Cascade = (Song)ctx.getBean("song4Cascade");
        // System.out.println(song4Cascade);
    }
}
