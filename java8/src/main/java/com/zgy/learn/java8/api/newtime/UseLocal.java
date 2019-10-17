package com.zgy.learn.java8.api.newtime;

import java.time.LocalDate;

/**
 * @Author: renjiaxin
 * @Despcription: 给人看的时间
 * @Date: Created in 2019/10/18 3:42
 * @Modified by:
 */
public class UseLocal {
    public static void main(String[] args) {
        // 日期 ，获取当前
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        // 创建日期
        LocalDate ld2 = LocalDate.of(2018,3,5);
        System.out.println(ld2);



    }
}
