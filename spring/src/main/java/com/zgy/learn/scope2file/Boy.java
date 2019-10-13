package com.zgy.learn.scope2file;

/**
 * @Author: renjiaxin
 * @Despcription: Boy的POJO
 * @Date: Created in 2019/10/11 22:47
 * @Modified by:
 */
public class Boy {
    private int age;
    private String name;
    private String sex;
    private String address;

    private SuperCar car;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SuperCar getCar() {
        return car;
    }

    public void setCar(SuperCar car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", car=" + car +
                '}';
    }
}