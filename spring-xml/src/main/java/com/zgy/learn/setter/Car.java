package com.zgy.learn.setter;

/**
 * @Author: renjiaxin
 * @Despcription: Car， 通过属性注入
 * @Date: Created in 2019/10/11 1:24
 * @Modified by:
 */
public class Car {
    /**
     * 品牌
     */
    private String brand;
    /**
     * 价格
     */
    private double price;
    /**
     * 产地
     */
    private String origin;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", origin='" + origin + '\'' +
                '}';
    }
}
