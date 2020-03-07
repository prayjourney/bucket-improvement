package com.zgy.learn.aqs.tool;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: renjiaxin
 * @Despcription: 线程安全的HashSet的两种方式
 * @Date: Created in 2020/3/8 1:39
 * @Modified by:
 */
public class SafeHashSet {
    /**
     * 同理可证 ： ConcurrentModificationException
     * //1、Set<String> set = Collections.synchronizedSet(new HashSet<>());
     * //2、CopyOnWriteArraySet
     */
    public static void main(String[] args) {
        // Set<String> set = new HashSet<>();
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}