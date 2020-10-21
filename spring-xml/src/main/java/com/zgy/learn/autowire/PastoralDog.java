package com.zgy.learn.autowire;

/**
 * @Author: renjiaxin
 * @Despcription: 中华田园犬
 * @Date: Created in 2019/10/14 0:53
 * @Modified by:
 */
public class PastoralDog {
    private String name;
    private int age;
    private DogHost host;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DogHost getHost() {
        return host;
    }

    public void setHost(DogHost host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "PastoralDog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", host=" + host +
                '}';
    }
}
