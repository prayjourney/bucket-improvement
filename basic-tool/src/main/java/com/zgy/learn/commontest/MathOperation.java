package com.zgy.learn.commontest;

/**
 * @Author: renjiaxin
 * @Despcription: math的一些操作，向上，向下取整等
 * @Date: Created in 2020/3/27 1:07
 * @Modified by:
 */
public class MathOperation {
    public static void main(String[] args) {
        // 第一种：ceil是天花板的意思，表示向上取整。
        System.out.println(Math.ceil(1.01));  //2.0
        System.out.println(Math.ceil(-1.01)); //-1.0
        System.out.println(Math.ceil(1.5));   //2.0
        System.out.println(Math.ceil(-1.5));  //-1.0

        // 第二种：floor是地板的意思，表示向下取整。
        System.out.println(Math.floor(1.01)); //1.0

        // 第三种：round执行的就是数学上的四舍五入运行。
        System.out.println(Math.round(1.2));  //1.0
        System.out.println(Math.round(5.8));  //6.0
        // 幂次方
        System.out.println(Math.pow(2, 3));
        // 开二次方
        System.out.println(Math.sqrt(9.3));
    }
}
