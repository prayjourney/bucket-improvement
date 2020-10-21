package com.zgy.learn.hibernate.entity2;

import org.springframework.stereotype.Component;

/**
 * @Author: renjiaxin
 * @Despcription: 老师
 * @Date: Created in 2019/10/27 14:50
 * @Modified by:
 */
@Component
public class Teacher {
    private int tid;
    private String name;
    private String gender;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
