package com.zgy.learn;

import com.zgy.learn.bean.Boss;
import com.zgy.learn.bean.Car;
import com.zgy.learn.config.MainConfigAutowired;
import com.zgy.learn.dao.BookDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/30 15:16
 * @Modified by:
 */
public class AutowiredTest {
    AnnotationConfigApplicationContext context = null;

    @Before
    public void before() {
        // 获取context
        context = new AnnotationConfigApplicationContext(MainConfigAutowired.class);
        System.out.println("获取了context...");
    }

    @After
    public void after() {
        context.close();
        System.out.println("context已经关闭...");
    }

    @Test
    public void test01() {
        BookDao bean = context.getBean(BookDao.class);
        System.out.println(bean.getLable());
    }

    @Test
    public void test02() {
        // 通过类型获取
        Boss bean = (Boss) context.getBean(Boss.class);
        System.out.println(bean);
        Car car = (Car) context.getBean("littleCar");
        System.out.println(car);
    }
}
