package com.zgy.learn.aop.annotation.common;

import com.zgy.learn.aop.annotation.common.pojo.Robot;
import com.zgy.learn.aop.annotation.common.service.RobotService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RobotServiceMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aop-annotation2.xml");
        RobotService rs = (RobotService) context.getBean("robotService");
        rs.closeRobot();
        Robot robot = (Robot) context.getBean("robot");
        Robot robot1 = (Robot) context.getBean("robot1");
        System.out.println(robot);
        System.out.println(robot1);
    }
}
