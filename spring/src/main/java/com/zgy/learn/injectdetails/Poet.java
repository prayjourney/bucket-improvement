package com.zgy.learn.injectdetails;

/**
 * @Author: renjiaxin
 * @Despcription: 歌曲词作者
 * @Date: Created in 2019/10/11 2:26
 * @Modified by:
 */
public class Poet {
    /**
     * 作者姓名
     */
    private String name;
    /**
     * 作者年龄
     */
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 使用属性注入的时候， 必须要有无参构造器， 或者没有显示的有参构造器
    public Poet() {
    }

    public Poet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Poet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
