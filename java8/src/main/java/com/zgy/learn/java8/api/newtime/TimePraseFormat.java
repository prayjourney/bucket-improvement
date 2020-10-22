package com.zgy.learn.java8.api.newtime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: renjiaxin
 * @Despcription: 解析是字符串-->时间， 格式化是时间——>字符串
 * @Date: Created in 2019/10/18 4:12
 * @Modified by:
 */
public class TimePraseFormat {
    public static void main(String[] args) {
        // 各种格式化的方式
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter dtf2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.of(2018, 9, 4, 2, 3, 4);
        System.out.println(localDateTime);
        // 是一个不认识的对象
        System.out.println(dtf1);
        String ss1 = dtf1.format(localDateTime);
        // 等价于toString
        String ss10 = localDateTime.toString();
        String ss2 = dtf2.format(localDateTime);
        // 将时间日期格式化为字符串
        String ss3 = dtf3.format(localDateTime);
        System.out.println(ss1);
        System.out.println(ss10);
        System.out.println(ss2);
        System.out.println(ss3);

        System.out.println("----------------");
        String tt = "2018-09-04日 02:03:04";
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy-MM-dd日 HH:mm:ss");
        // 解析字符串
        LocalDateTime ldt4 = LocalDateTime.parse(tt, dtf4);
        System.out.println(ldt4);

    }
}
