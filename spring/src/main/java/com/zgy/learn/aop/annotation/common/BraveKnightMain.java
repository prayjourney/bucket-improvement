package com.zgy.learn.aop.annotation.common;

import com.zgy.learn.aop.annotation.common.pojo.BraveKnight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BraveKnightMain {
    private static Logger logger = LoggerFactory.getLogger(BraveKnight.class);
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext();
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-annotation2.xml");
        BraveKnight br = (BraveKnight) ac.getBean("knight");
        logger.debug("准备调用 %s 方法", "br.saying()");
        br.saying();
        logger.info("%s 方法调用完毕", "br.saying()");
    }
}
