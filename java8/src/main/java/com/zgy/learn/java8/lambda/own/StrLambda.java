package com.zgy.learn.java8.lambda.own;

import org.junit.Test;

public class StrLambda {
    /**
     * 在此处处理， 但这只是一个半成品，需要在实际调用的时候实现我们具体的处理方法
     *
     * @param s  字符串
     * @param sf 处理接口
     * @return 处理后的字符串
     */
    public String operate(String s, StrFunInterface sf) {
        return sf.deal(s);
    }

    // 将字符串大写
    @Test
    public void upperStr() {
        // 返回的是一个String
        String upStr = operate("12EErrrMPjkj", (s) -> s.toUpperCase());
        System.out.println(upStr);

    }

    // 将字符串截断
    @Test
    public void subStr() {
        // 返回的是一个String
        String subStr = operate("你好啊，中国！人民万岁 啊，真正的！", (s) -> s.substring(1,10));
        System.out.println(subStr);
    }
}
