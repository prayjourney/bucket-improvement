package com.zgy.learn.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/30 16:39
 * @Modified by:
 */
// 默认加载到ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作， 就是说对象都是使无参构造器来初始化的
public class Boss {
    private String name;
    private Car car;

    public Boss() {
    }

    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss...有参构造器");
    }

    public Boss(Car car, String name) {
        this.car = car;
        this.name = name;
        System.out.println("Boss...有参构造器, 参数是car + name");
    }


    public Car getCar() {
        return car;
    }


    //@Autowired
    //标注在方法，Spring容器创建当前对象，就会调用方法，完成赋值；
    //方法使用的参数，自定义类型的值从ioc容器中获取 Car从容器之中获取, 如果找不到， 就会报错
    public void setCar(Car car) {
        this.car = car;
    }


    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", littleCar=" + car +
                '}';
    }
}
