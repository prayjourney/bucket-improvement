package com.zgy.learn.crud.entities;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @Author: renjiaxin
 * @Description: Girl
 * @Date: 2019-11-11 02:45
 * @Modified by:
 */
public class Girl {
    // 数据校验, 不能为空
    @NotEmpty
    private String name;
    // private int age;
    // Integer好处理一点, 可以处理空的值
    private Integer age;
    private String size;

    // 数据校验, 是当前之前的一个时间, 格式化
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  birth;
    // 格式化
    @NumberFormat(pattern = "#,###,###,###.#")
    private Float salary;

    public Girl(){

    }
    public Girl(String name, Integer age, String size){
        this.age=age;
        this.name=name;
        this.size=size;
    }

    public void setAge(Integer age) {
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", size='" + size + '\'' +
                ", birth=" + birth +
                ", salary=" + salary +
                '}';
    }
}
