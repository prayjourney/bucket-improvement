package com.zgy.learn.aqs.callable;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/3/8 2:39
 * @Modified by:
 */
public class UseCallable {
    public static void main(String[] args) {
        // new Thread(new Runnable()).start();
        // new Thread(new FutureTask<V>()).start();
        // new Thread(new FutureTask<V>( Callable )).start();
        try {
            Callable hc = new HelloCallable();
            FutureTask<HelloCallable> fthc = new FutureTask<HelloCallable>(hc);
            Thread thread = new Thread(fthc);
            // 启动线程
            thread.start();
            // 获取返回值，//这个get 方法可能会产生阻塞！// 结果被缓存
            String time = String.valueOf(fthc.get());
            // String time = new HelloCallable().call(); // 这相当于是Runnable的run方法，启动线程，都是用start
            System.out.println(time);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Runnable没有返回值，run方法不能抛出异常
class HelloRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("HelloRunnable!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class HelloCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        System.out.println("HelloRunnable!");
        // 返回上海时间
        return LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))).format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
