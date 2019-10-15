package com.zgy.learn.java8.lambda.refmethod.constructor;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/15 3:03
 * @Modified by:
 */
public class Laptop {
    private String name;

    private String type;

    private double price;
    private String time;

    public Laptop(String name) {
        this.name = name;
    }

    public Laptop(String name, String type) {
        this.name = name;
        this.type = type;
    }
    // 无法创建(String name, String time)


    public Laptop(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Laptop(String name, String type, double price, String time) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", time='" + time + '\'' +
                '}';
    }
}
