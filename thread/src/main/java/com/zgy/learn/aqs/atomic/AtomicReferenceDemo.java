package com.zgy.learn.aqs.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: renjiaxin
 * @Despcription: 原子引用的demo
 * @Date: Created in 2020/3/29 1:48
 * @Modified by:
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        //useNoStamp();
        useWithStamp();

    }

    /**
     * 没有版本号，ABA问题就没有解决
     */
    public static void useNoStamp() {
        AtomicReference<String> arf = new AtomicReference<>("helloWorld!");
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(arf.compareAndSet("helloWorld!", "helloWosdffffrld!"));
                System.out.println(arf.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(arf.compareAndSet("helloWosdffffrld!", "helloWorld!"));
                System.out.println(arf.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }

    /**
     * 版本号解决ABA问题就没有解决
     */
    public static void useWithStamp() {
        AtomicStampedReference<String> arf = new AtomicStampedReference<>("helloWorld!", 1);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(arf.compareAndSet("helloWorld!", "helloWosdffffrld!",
                        1, 2));
                System.out.println(arf.getReference());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(arf.compareAndSet("helloWosdffffrld!", "helloWorld!",
                        1, 2));
                System.out.println(arf.getReference());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
    }
}
