package com.zgy.learn.builder;

/**
 * @Author: renjiaxin
 * @Despcription: 构建的具体产品, 此处这个具体产品是车
 * @Date: Created in 2020/2/24 1:02
 * @Modified by:
 */
public class Car {
    private String shell; //外壳
    private String baseplate; // 底盘
    private String tyre; // 轮胎
    private String engine; //引擎

    public void setShell(String shell) {
        this.shell = shell;
    }

    public void setBaseplate(String baseplate) {
        this.baseplate = baseplate;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "shell='" + shell + '\'' +
                ", baseplate='" + baseplate + '\'' +
                ", tyre='" + tyre + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
