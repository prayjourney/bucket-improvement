package com.zgy.learn.feature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * final关键字的使用
 * https://www.cnblogs.com/zxfei/p/10735225.html
 * https://www.nowcoder.com/questionTerminal/4a8b3898663f47ed9514613a3ef6ae47
 * https://www.cnblogs.com/dolphin0520/p/3736238.html
 * https://www.cnblogs.com/dolphin0520/p/3811445.html
 */
public class AboutFinal {
    // final 常常量
    private final static String STR_MESSAGE = "Hello World!";

    public static void main(String[] args) {
        // 使用final修饰的常量
        System.out.println(STR_MESSAGE);
        // 使用final修饰的方法
        Apple apple = new Apple("苹果三代", "中国");
        System.out.println(apple.getInfo());

        // 使用final修饰的类
        Goat goat1 = new Goat("山羊", 1, "中国");
        System.out.println(goat1.toString());
        goat1.setAge(5);
        System.out.println(goat1.toString());
        // 改变final修饰的对象的其中的字段属性，仍然是可以的， 但改变地址就不行， 如果是基本类型+String，就不能修改
        final Goat goat2 = new Goat("黑色山羊", 9, "日本");
        System.out.println(goat2.toString());
        goat2.setAge(5);
        goat2.setOrigin("日本 + 巴西");
        System.out.println(goat2.toString());

        // STR_MESSAGE="ppp"; // error:基本类型+String，就不能修改
        // goat2 =new Goat("",2,""); // error:将一个final对象指向新的对象（地址），就不能修改


    }
}

/**
 * 山羊的最终类， 不容许继承
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
final class Goat {
    private String name;
    private Integer age;
    private String origin;
}

@Getter
@Setter
@ToString
class Man {
    private String name;
    private Integer age;
    // error
    // private final String gender;
    private String gender;
}

@Setter
@Getter
@AllArgsConstructor
class Apple {
    String name;
    String origin;

    // final修饰函数，不允许被重写， 早期就java之中的private方法， 是隐式的final的， 可以内联， 节省调度空间
    public final String getInfo() {
        return String.format("info： name is %s, origin is %s", this.name, this.origin);

    }
}




