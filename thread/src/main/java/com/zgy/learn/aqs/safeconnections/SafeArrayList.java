package com.zgy.learn.aqs.safeconnections;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: renjiaxin
 * @Despcription: 线程安全的ArrayList三种方式
 * @Date: Created in 2020/3/8 1:38
 * @Modified by:
 */
// java.util.ConcurrentModificationException 并发修改异常！
public class SafeArrayList {
    public static void main(String[] args) {
        // 并发下 ArrayList 不安全的吗，Synchronized；
        /**
         * 解决方案；
         * 1、List<String> list = new Vector<>();
         * 2、List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3、List<String> list = new CopyOnWriteArrayList<>()；
         */
        // CopyOnWrite 写入时复制 COW 计算机程序设计领域的一种优化策略；
        // 多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
        // 在写入的时候避免覆盖，造成数据问题！
        // 读写分离
        // CopyOnWriteArrayList 比 Vector Nb 在哪里？
        //              ===>使用的是reentranlock，vector使用的是synchronized, 性能更好一些
        //              ===>读写分离，在写入的时候避免覆盖，造成数据问题！
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}