package com.zgy.learn.java8;

import java.util.Optional;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/6/21 0:28
 * @Modified by: java8之中的optional类
 */
public class J8Optional {
    public static void main(String[] args) {
        J8Optional opt = new J8Optional();
        opt.testCreateOptional();
        opt.testCreateOptional02();

    }

    public void testCreateOptional(){
        // empty, 只是创建空实例
        Optional<Object> empty = Optional.empty();
        // of不能创建null实例
        Optional<String> hello = Optional.of("hello");
        // ofNullable, 如果为空就创建null, 不为空就正常创建
        Optional<String> s = Optional.ofNullable("123");

        System.out.println(empty.get());
        System.out.println(s.get());
        System.out.println(hello.get());
    }

    public void testCreateOptional02(){
        // ofNullable, 如果为空就创建null, 不为空就正常创建
        Optional<String> s = Optional.ofNullable(null);
        if (s.isPresent()){
            System.out.println();
        }
        // 如果为空，提供了一个默认值
        String ss = s.orElse(new String("hello mmmm"));
        System.out.println(ss);
    }

}
