package com.zgy.learn.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @Author: renjiaxin
 * @Despcription: 小明的一天，业务类
 * @Date: Created in 2019/10/14 2:04
 * @Modified by:
 */
@Component
public class XiaoMing {
    private int age;
    private String name;
    private int salary;


    public void goToWork(String time, String status) {
        System.out.println("去上班....");
    }

    public void work(String time, String status) {
        System.out.println("工作中....");
    }

    public void offWork(String time, String status) {
        System.out.println("下班了...");
    }

    public void goToBed(String time, String status) {
        System.out.println("上床睡觉...");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "XiaoMing{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
