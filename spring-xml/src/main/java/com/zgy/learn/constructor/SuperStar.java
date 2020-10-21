package com.zgy.learn.constructor;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/11 1:45
 * @Modified by:
 */
public class SuperStar {
    /**
     * 年龄
     */
    private int age;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;

    // 貌似没有对无参构造函数有一定要有的要求，这个后面注意一下
    public SuperStar() {
    }

    public SuperStar(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
