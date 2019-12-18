package com.zgy.learn.feature;

/**
 * @Author: renjiaxin
 * @Despcription: 主要是大于128和小于128的两种状态
 * @Date: Created in 2019/12/18 22:14
 * @Modified by:
 */
public class AboutInteger {
    public static void main(String[] args) {
        // 128和129一样
        Integer i129 = 129;
        Integer i1292 = new Integer(129);
        // == 比较对象
        System.out.println(i129==i1292);          // false
        // equals比较值
        System.out.println(i129.equals(i1292));   // true

        int int129 = 129;
        // == 比较对象
        System.out.println(i129==int129);         // true
        // equals比较值
        System.out.println(i1292.equals(int129)); // true


        System.out.println("================");
        Integer i12 = 12;
        Integer i122 = new Integer(12);
        int i123 = 12;
        System.out.println(i12 == i122);
        System.out.println(i12.equals(i122));
        System.out.println(i12 == i123);
        System.out.println(i12.equals(i123));
        System.out.println(i122 == i123);
        System.out.println(i122.equals(i123));

    }
}
