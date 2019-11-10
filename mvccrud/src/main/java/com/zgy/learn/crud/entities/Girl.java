package com.zgy.learn.crud.entities;

/**
 * @Author: renjiaxin
 * @Description: Girl
 * @Date: 2019-11-11 02:45
 * @Modified by:
 */
public class Girl {
    private String name;
    // private int age;
    // Integer好处理一点, 可以处理空的值
    private Integer age;
    private String size;
    public Girl(){

    }
    public Girl(String name, int age, String size){
        this.age=age;
        this.name=name;
        this.size=size;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", size='" + size + '\'' +
                '}';
    }
}
