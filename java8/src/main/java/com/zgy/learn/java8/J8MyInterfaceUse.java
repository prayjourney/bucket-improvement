package com.zgy.learn.java8;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/6/21 13:05
 * @Modified by:
 */
public class J8MyInterfaceUse {
    public static void main(String[] args) {
        System.out.println(MyInterface.getVersion());
        System.out.println(new HelloWorld().version());
        System.out.println(new HelloWorld().getName());
        // 类优先原则， 调用的是抽象类MyAbstractClass的myName方法
        System.out.println(new HelloWorld().myName());
    }

    static class HelloWorld extends MyAbstractClass implements MyInterface{
        @Override
        public String getName() {
            return "hello";
        }
    }
}

interface MyInterface{
    // default关键字， 可以定义多个default的方法
    default String myInfo(){
        return "myinfo";
    }

    // 可以定义静态的有方法体的方法
    public static String getVersion(){
        return "1.0";
    }

    default String version(){
        return "1.0";
    }

    default String myName(){
        return "Hong Kong";
    }

    // 普通的方法不能有方法体
    public String getName();
}

abstract class MyAbstractClass{
    public String myName(){
        return "香港";
    }
}
