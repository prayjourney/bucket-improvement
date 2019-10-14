package com.zgy.learn.aop.annotation.common;

import com.zgy.learn.aop.annotation.common.pojo.BraveKnight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BraveKnightMain {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext();
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-annotation2.xml");
        BraveKnight br = (BraveKnight) ac.getBean("knight");
        br.saying();
    }
}
