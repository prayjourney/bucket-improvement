package com.zgy.learn.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @Author: renjiaxin
 * @Despcription: 此处没有写@Compenent注解
 * @Date: Created in 2019/12/29 11:56
 * @Modified by:
 */
@Getter
@Setter
//@Component
public class Cat {
    private String name;

    public Cat() {
        System.out.println("cat 的构造器。。。");
    }

    public void init() {
        System.out.println("cat 的初始化方法！");
    }

    public void myDestoryMethod() {
        System.out.println("销毁cat时调用！");
    }

}
