package com.zgy.learn.commontest;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/25 3:29
 * @Modified by:
 */
// 无参数的枚举
enum MyEnum01 {
    BLUE, RED, GREEN;
}

// 有参数的枚举
enum MyColor {
    BLUE("蓝色妖姬"), RED("烈焰红唇"), YELLOW("黄不可耐");
    String name;

    MyColor(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class EnumTest {
    public static void main(String[] args) {
        System.out.println("我最喜欢的颜色：" + MyColor.RED.name);
        System.out.println("test: " + MyEnum01.BLUE);
    }

}

