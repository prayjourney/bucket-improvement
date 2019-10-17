package com.zgy.learn.java8.api.newtime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;

/**
 * @Author: renjiaxin
 * @Despcription: 给机器看的时间
 * @Date: Created in 2019/10/18 3:53
 * @Modified by:
 */
public class UseTime4Computer {
    public static void main(String[] args) throws InterruptedException {
        // 获取当前UTC时间， 格林威治
        Instant start = Instant.now();
        System.out.println(start);
        Thread.sleep(2000);
        Instant end = Instant.now();
        // 纳秒
        long t = end.getNano() - start.getNano();
        // 秒
        long t1 = end.getEpochSecond() - start.getEpochSecond();
        System.out.println(t);
        System.out.println(t1);
        // 构造时间
        Instant i = Instant.ofEpochMilli(123123213123L);

        // 转化成LocalDateTime
        LocalDateTime lll = LocalDateTime.ofInstant(i, ZoneId.of("Asia/Shanghai"));
        System.out.println(lll);
        // 时间相隔
        Duration d1 = Duration.between(start, end);

        // 日期相隔
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate l2 = LocalDate.of(1999, 2, 3);
        LocalDateTime l3 = LocalDateTime.of(2001, 2, 4, 1, 2);
        // LocalDate之间的转换LocalDateTime
        LocalDate l4 = l3.toLocalDate();

        Period p1 = Period.between(l2, l4);
        System.out.println(d1);
        System.out.println(p1);

    }
}
