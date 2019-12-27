package com.zgy.learn;

import com.zgy.learn.bean.Person;
import com.zgy.learn.config.MainConfig;
import com.zgy.learn.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/27 17:20
 * @Modified by:
 */
public class AllTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        // 打印加载后的bean的名字
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Person bean1 = (Person) context.getBean("guanyu");
        Person bean2 = (Person) context.getBean("guanyu");
        System.out.println("bean1 == bean2 : " + (bean1 == bean2));
    }

}
