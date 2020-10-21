package com.zgy.learn.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription: 测试xml aop
 * @Date: Created in 2019/10/18 4:34
 * @Modified by:
 */
public class JisuanHoo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-xml.xml");
        JisuanService js = (JisuanService) context.getBean("jisuan");
        js.operate(5, 6, (x, y) -> x + y);
        js.test();
        js.operate(10, 3, (x, y) -> {
            System.out.println(".....");
            return x - y;

        });
        js.show("钟馗");


    }
}
