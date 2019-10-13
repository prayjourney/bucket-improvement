package com.zgy.learn.autowire;

/**
 * @Author: renjiaxin
 * @Despcription: 田园犬主人
 * @Date: Created in 2019/10/14 0:53
 * @Modified by:
 */
public class DogHost {
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "DogHost{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
