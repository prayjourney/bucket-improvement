package com.zgy.learn;

import com.zgy.learn.bean.Color;
import com.zgy.learn.bean.ColorFactoryBean;
import com.zgy.learn.bean.Person;
import com.zgy.learn.bean.Rainbow;
import com.zgy.learn.config.BeanDefineConfig;
import com.zgy.learn.config.MainConfig;
import com.zgy.learn.config.MainConfig2;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

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

    // singleton的bean, 使用懒加载
    @Test
    public void test05() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            // 名字是一直有的，但是没有创建对象
//            if ("ceshi2".equals(name)) {
//                System.out.println("ceshi2的bean已经创建好了！");
//            }
            System.out.println(name);
        }
        //context.getBean("ceshi2");
        System.out.println("singleton默认容器创建就加载，使用@Lazy, 可以让它在调用的时候再去创建！");
    }


    // 按照类型获取所有的person的bean
    @Test
    public void test06() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Environment environment = context.getEnvironment();
        ClassLoader classLoader = context.getClassLoader();
        String applicationName = context.getApplicationName();
        System.out.println("beanFactory :" + beanFactory.getClass().getName());
        System.out.println("environment :" + environment.toString());
        System.out.println("classLoader :" + classLoader.getClass().getName());
        System.out.println("applicationName :" + applicationName);


    }

    // 使用不同的方式创建bean
    @Test
    public void test07() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanDefineConfig.class);
        // 获取所有定义了的bean
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        // 测试scope是否起效， 为singleton
        Rainbow rainbow1 = (Rainbow) context.getBean("rainbow");
        Rainbow rainbow2 = (Rainbow) context.getBean("rainbow");
        System.out.println("rainbow1 == rainbow2: " + (rainbow1 == rainbow2));

        // ColorFactoryBean来获取bean
        System.out.println("使用ColorFactoryBean来获取bean。。。");
        // 获取我们自定义的factoryBean，然后输出他的类型， 是它里面的包含的类型信息的类型
        // factoryBean.getClass(): class com.zgy.learn.bean.Color
        Object factoryBean = context.getBean("colorFactoryBean");
        System.out.println("factoryBean.getClass(): " + factoryBean.getClass());
        // 获取我们的自定义的bean工厂的类型， name之前要用&来修饰
        // factoryBean2.getClass(): class com.zgy.learn.bean.ColorFactoryBean
        Object factoryBean2 = context.getBean("&colorFactoryBean");
        System.out.println("factoryBean2.getClass(): " + factoryBean2.getClass());

        // 下面的不算， 我们自己去创建管理了ColorFactoryBean， 但是还是证明了它是prototype的
        ColorFactoryBean colorBean = new ColorFactoryBean();
        System.out.println("colorBean的类型：" + colorBean.getClass());
        try {
            Color object1 = colorBean.getObject();
            Color object2 = colorBean.getObject();
            System.out.println("object1==object2: " + (object1 == object2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
