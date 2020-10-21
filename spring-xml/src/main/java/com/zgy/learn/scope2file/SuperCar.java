package com.zgy.learn.scope2file;

/**
 * @Author: renjiaxin
 * @Despcription: 超级小卡车
 * @Date: Created in 2019/10/13 21:15
 * @Modified by:
 */
public class SuperCar {
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SuperCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
