package com.zgy.learn.java8.api.newtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * @Author: renjiaxin
 * @Despcription: 给人看的时间日期
 * @Date: Created in 2019/10/18 3:42
 * @Modified by:
 */
public class UseTime4People {
    public static void main(String[] args) {
        // 日期 ，获取当前
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        // 创建日期
        LocalDate ld2 = LocalDate.of(2018, 3, 5);
        System.out.println(ld2);


        System.out.println("===================");
        // 日期时间 ，获取当前
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        // 创建日期时间
        LocalDateTime ldt2 = LocalDateTime.of(2018, 3, 5, 3, 4);
        LocalDateTime ldt3 = LocalDateTime.of(2018, 3, 5, 3, 4, 22);
        System.out.println(ldt2);
        System.out.println(ldt3);


        System.out.println("===================");
        // 获取当前时间
        LocalTime lt = LocalTime.now();
        // 获取指定时区的当前时间
        LocalTime lt2 = LocalTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(lt);
        System.out.println(lt2);
        // 创建时间
        LocalTime lt3 = LocalTime.of(3, 4);
        LocalTime lt4 = LocalTime.of(3, 4, 5);
        System.out.println(lt3);
        System.out.println(lt4);

    }
}
