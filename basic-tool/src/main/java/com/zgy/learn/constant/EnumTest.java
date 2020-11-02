package com.zgy.learn.constant;

/**
 * @Author renjiaxin
 * @Date 2020/11/2
 * @Description
 */
public class EnumTest {
    public static void main(String[] args) {
        // 测试没有参数的枚举类
        System.out.println(NoArgEnum.BLUE);
        System.out.println(NoArgEnum.values());

        // 测试有参数的枚举类
        System.out.println(OneArgEnum.RED);
        // 获取值
        System.out.println(OneArgEnum.RED.val());
        System.out.println(OneArgEnum.values());
    }
}
