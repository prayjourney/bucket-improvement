package com.zgy.learn.createtype.builder;

/**
 * @Author: renjiaxin
 * @Despcription: 通过指挥官，指挥具体的建造者，然后获得产品
 * @Date: Created in 2020/2/24 1:22
 * @Modified by:
 */
public class CarBuilderTest {
    public static void main(String[] args) {
        // 通过指挥官，指挥具体的建造者，然后获得产品
        Car car = new Director().build(new CarBuilder());
        System.out.println(car.toString());
    }
}
