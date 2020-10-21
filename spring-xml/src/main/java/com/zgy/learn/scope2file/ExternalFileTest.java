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
        Boy zgy = (Boy) context.getBean("zgy");
        System.out.println(zgy.toString());

        // 测试继承 parent
        Human h1 = (Human) context.getBean("beijingren1");
        System.out.println(h1.toString());
        Human h2 = (Human) context.getBean("beijingren2");
        System.out.println(h2.toString());
        Human h3 = (Human) context.getBean("beijingren3");
        System.out.println(h3.toString());

        // 测试依赖 depends-on
        Boy boy2 = (Boy) context.getBean("boy2");
        System.out.println(boy2.toString());

        Boy boy3 = (Boy) context.getBean("boy3");
        System.out.println(boy3.toString());

        Boy sb = (Boy) context.getBean("superBoy");
        System.out.println(sb);

        // 测试p空间
        Boy sbBoy = (Boy) context.getBean("sbBoy2");
        System.out.println(sbBoy);
        SuperCar scar = (SuperCar) context.getBean("car2");
        System.out.println(scar);

        // 测试bean的scope human1是prototype，每次返回不同对象, human2是single，每次返回相同对象
        Human human11 = (Human) context.getBean("human1");
        Human human12 = (Human) context.getBean("human1");
        System.out.println("human11==human12: " + (human11 == human12));

        Human human21 = (Human) context.getBean("human2");
        Human human22 = (Human) context.getBean("human2");
        System.out.println("human21==human22: " + (human21 == human22));


    }
}
