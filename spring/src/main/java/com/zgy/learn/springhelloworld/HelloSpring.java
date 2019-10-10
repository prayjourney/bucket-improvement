package com.zgy.learn.springhelloworld;

/**
 * @Author: renjiaxin
 * @Despcription: HelloSpring
 * @Date: Created in 2019/10/10 22:02
 * @Modified by:
 */
public class HelloSpring {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloSpring{" +
                "name='" + name + '\'' +
                '}';
    }
}
