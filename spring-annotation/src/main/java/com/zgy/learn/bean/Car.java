package com.zgy.learn.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/29 13:05
 * @Modified by:
 */
// 使用InitializingBean, DisposableBean之后，可以使用初始化和销毁方法，
// 使用@Component可以使用@ComponentScan或者@ComponentScans注解，就不用在在配置之中自己去创建对象了
@Component(value = "littleCar")
public class Car implements InitializingBean, DisposableBean {
    public Car() {
        System.out.println("car 的构造器。。。");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(" car的销毁方法。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car 构造出来之后，然后进行其他的一些设置。。。");

    }
}
