package com.zgy.learn.constant;

/**
 * @Author renjiaxin
 * @Date 2020/11/2
 * @Description 有参数的枚举类
 */
public enum OneArgEnum {
    RED("red"), YELLOW("yellow"), BLUE("blue");
    private String name;

    private OneArgEnum() {
    }

    private OneArgEnum(String name) {
        this.name = name;
    }

    public String val() {
        return name;
    }

}
