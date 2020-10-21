package com.zgy.learn;

import com.zgy.learn.bean.Person;
import com.zgy.learn.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class MainTest {
    public static void main(String[] args) {
        // 使用xml方式配置的时候的配置类是 ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person p = (Person) context.getBean("person");
        Person p = (Person) context.getBean("helloperson"); //修改后，名字就成了helloperson了
        System.out.println(p);

        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            // 输出person的bean的名字
            System.out.println(name);
        }

    }
}
