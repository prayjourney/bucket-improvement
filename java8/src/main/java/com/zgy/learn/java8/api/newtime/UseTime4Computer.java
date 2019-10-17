package com.zgy.learn.java8.api.newtime;

import java.time.Instant;
import java.time.LocalDateTime;
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

    }
}
