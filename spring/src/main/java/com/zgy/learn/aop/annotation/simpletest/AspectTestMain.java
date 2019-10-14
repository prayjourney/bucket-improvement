package com.zgy.learn.aop.annotation.simpletest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/14 2:24
 * @Modified by:
 */
public class AspectTestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-annotation.xml");
        // 类默认的bean
        XiaoMing x1 = (XiaoMing) context.getBean("xiaoMing");
        // 自己定义的bean
        XiaoMing x2 = (XiaoMing) context.getBean("xiaoming");
        x1.goToBed("01:20", "很困！");
        x2.goToWork("07:20", "也很困！");
    }
}
