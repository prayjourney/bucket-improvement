package com.zgy.learn.createtype.singleton;

/**
 * @Author: renjiaxin
 * @Despcription: 使用枚举的方式，实现单例，枚举无法被反射，屏蔽了反射
 * @Date: Created in 2020/2/23 13:21
 * @Modified by:
 */
public enum SingletonEnum {
    INSTANCE;

    public SingletonEnum getInstance() {
        return INSTANCE;
    }

}

// 测试
class SingletonEnumTest {
    public static void main(String[] args) {
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        System.out.println(instance1 == instance2);
    }
}
