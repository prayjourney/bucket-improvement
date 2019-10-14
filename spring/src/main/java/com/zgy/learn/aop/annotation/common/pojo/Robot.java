package com.zgy.learn.aop.annotation.common.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 使用注解的时候， 怎么给每个robot对象赋值呢？比如name,type等？
// 在POJO的属性上面，通过value来实现赋值，属性还可以从外界的文件中获取，比如robot.properties中，使用${}获取，例子如下
@Component
public class Robot {
    @Value(value = "洛欧比特")
    private String name;
    @Value("${robot.type}")
    private String type;
    @Value("${robot.function}")
    private String function;

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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", function='" + function + '\'' +
                '}';
    }

    public void openRobot() {
        System.out.println("正在开机。。。");
    }

    public void closeRobot() {
        System.out.println("正在关机。。。");
    }

    public void sweepFloor() {
        System.out.println("我正在扫地。。。");
    }

    public void infuseTea() {
        System.out.println("我正在沏茶。。。");
    }
}
