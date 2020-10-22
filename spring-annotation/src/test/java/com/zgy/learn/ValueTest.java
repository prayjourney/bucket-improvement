package com.zgy.learn;

import com.zgy.learn.bean.Diamond;
import com.zgy.learn.bean.Person;
import com.zgy.learn.config.MainConfigOfPropertyValue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

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

    @Test
    public void test02() {
        Diamond diamond = (Diamond) context.getBean("diamondxxx");
        System.out.println(diamond);
        // 配置文件中的值，加载之后，就会传入到环境之中，ConfigurableEnvironment，可以获取
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("diamond price :" + environment.getProperty("diamond.price"));
    }
}
