package com.zgy.learn.java8.lambda.ofiical;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lambda虽然挺好的，但是我们每次要去写一个接口，挺麻烦的，所以我们可以使用官方提供的四个标准接口
 * /*
 * * Java8 内置的四大核心函数式接口
 * *
 * * Consumer<T> : 消费型接口
 * * 		void accept(T t);
 * *
 * * Supplier<T> : 供给型接口
 * * 		T get();
 * *
 * * Function<T, R> : 函数型接口
 * * 		R apply(T t);
 * *
 * * Predicate<T> : 断言型接口
 * * 		boolean test(T t);
 * *
 * https://www.cnblogs.com/drl-blogs/p/10803413.html
 */
public class StandardUse {
    /**
     * 确定我们使用四大接口之中 的哪一种接口，这个的话关键在于，我们的返回值和参数
     * 消费型接口：无返回值，一个参数
     * 供给型接口：有返回值，无参数
     * 函数型接口：有返回值，一个参数
     * 断言型接口：boolean返回值，一个参数
     */
    // 1. 消费型接口, 无返回值，一个参数
    public void findFun(String mm, Consumer<String> s) {
        s.accept(mm);
    }

    // 测试消费型接口
    @Test
    public void testConsumer() {
        findFun("旅游", s -> System.out.println("我的爱好是：" + s));
    }

    // 2.供给型接口, 有返回值，无参数
    // 此处说的有无返回值， 是四大接口的有无返回值，和我们要实现的方法， 比如此处的getNumberList无关
    public List<Integer> getNumberList(int num, Supplier<Integer> su) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 相当于这一部分是个半成品，我们需要在调用的时候实际实现，这是就用到了lambda表达式
            ls.add(su.get());
        }
        return ls;
    }

    // 测试消费型接口
    @Test
    public void testSupplier() {
        // 是说，此处的Supplier接口，有返回值，无参数
        List<Integer> ll = getNumberList(10, () -> {
            Random r = new Random();
            return r.nextInt(100);
        });
        for (Integer i : ll) {
            System.out.println(i);
        }
    }

    // 3.函数型接口, 有返回值，一个参数, 前者是参数：String类型， 后者是返回值：Integer类型, 此处的dealString方法的返回值，
    //   和我们的Function接口的参数类型，返回值类型毫无关系！Function<T, R> : 函数型接口, R apply(T t);
    public void dealString(String str, Function<String, Integer> function) {
        // function.apply(str); 调用的时候，真正去实现， 使用lambda表达式
        int ss = function.apply(str);
        System.out.println(str + "的长度是： " + ss);
    }

    // 测试消费型接口
    @Test
    public void testFunction() {
        // 是说，此处的Function接口，有返回值，一个参数, 前者是参数：String类型， 后者是返回值：Integer类型
        dealString("helloWorld!", s -> {
            System.out.println("正在处理的字符串是： " + s);
            return s.length();
        });
    }

    // 4.断言型接口：boolean返回值，一个参数
    // 需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "html", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);

        for (String str : strList) {
            System.out.println(str);
        }
    }

    // 断言型接口， 返回布尔值，需要一个参数， 过滤掉不符合长度要求的字符串，然后返回一个list
    public List<String> strHandler(List<String> ls, int len, Predicate<String> ps) {
        List<String> newList = new ArrayList<>();
        for (String s : ls) {
            if (ps.test(s)) {
                newList.add(s);
            }
        }
        return newList;
    }

    @Test
    public void testStrHandler() {
        List<String> m = new ArrayList<>();
        List<String> ss = Arrays.asList(
                "12345",
                "fsdafasfsafa",
                "safsawwerwerwer",
                "张三李四a a dsf",
                "hello",
                "mm"
        );
//        m = strHandler(ss, 4, s1s -> {
//            List<String> newList = new ArrayList<>();
//            for (String s : ss) {
//                if (s.length() > 4) {
//                    newList.add(s);
//                }
//            }
//            return newList;
//        });
        List<String> strList = strHandler(ss, 4, (s) -> s.length() > 4);

        for (String str : strList) {
            System.out.println(str);
        }
    }



}
