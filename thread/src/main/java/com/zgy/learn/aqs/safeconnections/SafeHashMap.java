package com.zgy.learn.aqs.safeconnections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: renjiaxin
 * @Despcription: ConcurrentHashMap不允许key为null或者是value为null, HashMap和null的关系, 可以允许key或者value为null
 * @Date: Created in 2020/3/8 1:38
 * @Modified by:
 */
public class SafeHashMap {
    public static void main(String[] args) {
        // 和null之间的关系
        hashMapAndNull();
        concurrentHashMapAndNull();
        // 线程不安全
        //useHashMap();
        // 代替解决方式
        // 1. ConcurrentHashMap
        // 2. Collections.synchronizedMap()
        //useConcurrentHashMap();
        useConnectionsSynchronizedMap();


    }

    // 有可能不是1000，或者出现ConcurrentModificationException错误
    public static void useHashMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(
                        0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
        // 有可能出现ConcurrentModificationException错误
        System.out.println(map.size());
    }

    // 线程安全的
    public static void useConcurrentHashMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(
                        0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
        System.out.println(map.size());
    }


    // 线程安全的
    public static void useConnectionsSynchronizedMap() {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map = Collections.synchronizedMap(map1);
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(
                        0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
        System.out.println(map.size());
    }

    // HashMap和null的关系, 可以允许key或者value为null
    private static void hashMapAndNull() {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put(null, null); // 这个被覆盖了
        map.put("123", null);
        map.put("1231", null);
        System.out.println(map.size());
    }

    // ConcurrentHashMap不允许key为null或者是value为null
    private static void concurrentHashMapAndNull() {
        ConcurrentHashMap<String, String> conMap = new ConcurrentHashMap<>();
        // conMap.put(null, "123");
        // conMap.put("123", null);
        System.out.println(conMap.size());
    }
}
