package com.zgy.learn.pojo;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-04 15:42
 * @Modified by:
 */
public class Address {
    String name;
    double area;

    public double getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
