package com.zgy.learn.java8.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * java8的lambda表达式的学习
 * url: https://jingyan.baidu.com/article/ca00d56c3f20a3e99eebcfaf.html
 * https://www.jianshu.com/p/f258e9464a29
 * https://www.cnblogs.com/coprince/p/8692972.html
 * https://www.iteye.com/blog/shmilyaw-hotmail-com-2251821
 */
public class SimpleLambda {
    /**
     * lambda的格式：参数->语句，lambda需要接口的支持，这个接口，只能含有一个方法，也叫做函数式接口
     * 参数：是函数式接口的方法之中的参数
     * 语句：是函数式接口实现方法的语句
     * 基本的情况有6种：
     * 1.无参数无返回值 ()->System.out.println("1123");
     * <p>
     * 2.有1个参数无返回值 (x)->System.out.println(x);
     * <p>
     * 3.只有1个参数，小括号可以省略 x->System.out.println(x);
     * Consumer<String> cs = x-> System.out.println(x);
     * <p>
     * 4.有2个以上的参数，接口实现有多条语句，有返回值
     * Comparator<Integer> con = (x, y) -> {
     * System.out.println("参数是" + x + " & " + y);
     * return Integer.compare(x,y);
     * };
     * <p>
     * 5.有2个以上的参数，接口实现语句只有1条，有返回值， {}和return都可以省略
     * Comparator<Integer> con2 = (x, y) -> Integer.compare(x,y);
     * <p>
     * 6.lambda表达式的参数列表的数据类型，可以省略，lambda自带类型推断
     * Comparator<Integer> con2 = (Integer x, Integer y) -> Integer.compare(x,y);
     * Comparator<Integer> con2 = (x, y) -> Integer.compare(x,y);
     * <p>
     * 口诀：
     * 上联：左右遇一[个参数，条语句]括号省
     * 下联：左侧推断类型省
     * 横批：能省就省
     */
    public static void main(String[] args) {
        // 创建一个SimpleLambda的对象
        SimpleLambda sl = new SimpleLambda();
        // 1.无参数无返回值
        sl.test1Condition();

        // 2.有1个参数无返回值
        sl.test2Condition();

        // 3.只有1个参数，小括号可以省略
        sl.test3Condition();

        // 4.有2个以上的参数，接口实现有多条语句，有返回值
        sl.test4Condition();

        // 5.有2个以上的参数，接口实现语句只有1条，有返回值
        sl.test5Condition();

        // 6.参数列表中的参数类型可以省略
        sl.test6Condition();
    }

    public void test1Condition() {
        Runnable r = () -> System.out.println("Hello Lambda");
        // 此处不是为了跑多线程
        r.run();
    }

    public void test2Condition() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("lambda表达式有点酷啊！");
    }

    public void test3Condition() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("lambda表达式有点酷啊！参数只有1个的时候，不需要使用()包裹起来！");
    }

    public void test4Condition() {
        // 但是，这个好像是没有调用起来的啊？
        Comparator<Integer> comparator = (i, j) -> {
            System.out.println("参数是" + i + " & " + j);
            return Integer.compare(i, j);
        };
    }

    public void test5Condition() {
        // 但是，这个好像是没有调用起来的啊？
        Comparator<Integer> comparator = (i, j) -> Integer.compare(i, j);
    }

    public void test6Condition() {
        // 但是，这个好像是没有调用起来的啊？
        // Comparator<Integer> comparable = (Integer x ,Integer y) -> Integer.compare(x,y);
        Comparator<Integer> comparable = (x, y) -> Integer.compare(x, y);
    }
}
