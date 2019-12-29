package com.zgy.learn;

import com.zgy.learn.bean.Person;
import com.zgy.learn.config.MainConfigOfPropertyValue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/29 23:54
 * @Modified by:
 */
public class ValueTest {
    AnnotationConfigApplicationContext context = null;

    @Before
    public void before() {
        // 获取context
        context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        System.out.println("获取了context...");
    }

    @Test
    public void test01() {
        Person person = (Person) context.getBean("person");
        // 这样获取的person对象是没有值的，该怎么给注解模式的bean赋值呢？
        System.out.println(person);
    }
}
