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
        if (bean1 == bean2) {
            System.out.println("bean1 == bean2 : " + (bean1 == bean2));
        } else {
            System.out.println("bean1 和 bean2 不是同一个对象，@Scope(value = \"prototype\") 设置让每次创建的对象都不同！");
        }
    }

    // bean的scope设置为prototype， 这个时候，每次new的都是新对象
    @Test
    public void test03() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Person bean1 = (Person) context.getBean("ceshi");
        Person bean2 = (Person) context.getBean("ceshi");
        if (bean1 == bean2) {
            System.out.println("bean1 == bean2 : " + (bean1 == bean2));
        } else {
            System.out.println("bean1 和 bean2 不是同一个对象，@Scope(value = \"prototype\") 设置让每次创建的对象都不同！");
        }
    }

    // bean的scope设置为prototype，使用的时候才去调用创建bean的方法，不使用不去创建，而singleton容器一加载就创建bean
    @Test
    public void test04() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("我还没有使用propotype scope的bean，所以我没调用bean的创建方法！");
    }
}
