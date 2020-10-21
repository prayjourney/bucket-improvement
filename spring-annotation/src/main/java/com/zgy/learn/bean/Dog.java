package com.zgy.learn.bean;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: renjiaxin
 * @Despcription: 不使用@Component注解
 * @Date: Created in 2019/12/29 13:28
 * @Modified by:
 */
@Getter
@Setter
public class Dog {
    private String name;

    public Dog() {
        System.out.println("Dog的构造器！");
    }

    // 对象创建并赋值之后调用
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct 注解， 在构造对象完成之后，调用。。。");

    }

    // 容器移除对象之前
    @PreDestroy
    public void destory() {
        System.out.println("@PreDestroy 注解， 在对象销毁之前调用。。。");
    }

}
