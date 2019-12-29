package com.zgy.learn;

import com.zgy.learn.bean.Cat;
import com.zgy.learn.config.BeanLifeCycleConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/29 12:07
 * @Modified by:
 */
public class LifeCycleTest {
    AnnotationConfigApplicationContext context = null;

    @Before
    public void before() {
        // 获取context
        context = new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        System.out.println("获取了context...");
    }

    @After
    public void after() {
        context.close();
        System.out.println("context已经关闭...");
    }

    @Test
    public void test01() {
        Cat cat = (Cat) context.getBean("cat");
    }


}
