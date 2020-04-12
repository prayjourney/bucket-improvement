package com.zgy.learn.bootswagger.pojo;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/4/13 3:16
 * @Modified by:
 */
public class Student {
    private int id;
    private String name;
    private String gender;
    private String phoneNumber;

    public Student() {
    }

    public Student(int id, String name, String gender, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
