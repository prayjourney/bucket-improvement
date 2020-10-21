package com.zgy.learn.feature;

/**
 * https://www.cnblogs.com/guodongdidi/p/6953217.html#4248342
 * 如下是写的程序测试代码， 就是说一个整数有三种定义方式：int i=xxx; Integer a =xxxx; Integer b = new Integer(xxx)，
 * 但是受影响的除了定义方式，还有范围，受到的额外影响就是[-128,127]的范围内，创建对象都是使用缓存值，如果已经有包含这个值的对象，
 * 那就不再去创建新对象，所以这个范围内对象是同一个，此时Integer a =xxxx; 和 Integer b = new Integer(xxx)的 a==b的结果是true,
 * 此范围之外，就是会创建一个新的对象，a==b就相当于是两个对象比较地址是不是相同了， 而int i =xxx 和 下面两种Integer a =xxxx;
 * Integer b = new Integer(xxx)， 都是比较字面值，拆箱之后的字面值， 和对象比较没有关系了
 */
public class AboutIntegerSecond {
    public static void main(String[] args) {
        System.out.println("有三种定义方式：" +
                "int i=xxx;" +
                "Integer a =xxxx;" +
                "Integer b = new Integer(xxx)" +
                "受到的额外影响就是[-128,127]的范围内，创建对象都是使用缓存值，不去创建新对象，所以对象是同一个" +
                "此时Integer a =xxxx; 和 Integer b = new Integer(xxx)的 a==b的结果是true, 此范围之外，" +
                "就是会创建一个新的对象，a==b就相当于是两个对象比较地址是不是相同了， 而int i =xxx 和 下面两种" +
                "Integer a =xxxx; Integer b = new Integer(xxx)， 都是比较字面值，拆箱之后的字面值");

        System.out.println("\n=============================================================\n");
        int nu1 = 12;
        Integer nu2 = 12;
        System.out.println("nu1 == nu2 : " + (nu1 == nu2) + ", int和Integer直接赋值，比较是比较值"); //true
        int i128 = 128;
        Integer integer128 = 128;
        System.out.println("i123==integer123 : " + (i128 == integer128) + ", int和Integer创建对象，比较是比较值"); //true
        int i1234 = 1234;
        Integer integer1234 = new Integer(1234);
        System.out.println("i1234==integer1234 : " + (i1234 == integer1234) + ", int和Integer创建对象，Integer" +
                "是创建的对象，但是两个的值都是大于127的， 仍然是比较值"); // true

        System.out.println("\n=============================================================\n");


        Integer in1 = 127;
        Integer in2 = 127;
        System.out.println("in1 == in2 : " + (in1 == in2) + ", Integer in1和Integer in2直接赋值，" +
                "而非new(xxx) 赋值，但这是同一个对象"); //true

        Integer inta = 128;
        Integer intb = 128;
        System.out.println("inta == intb : " + (inta == intb) + ", Integer inta和Integer intb直接赋值，" +
                "而非new(xxx) 赋值，当这个值在[-128,127]之间，直接使用缓存值， 是同一个对象，但是在这个" +
                "范围之外， 就需要创建新的对象了， 128刚好在之外，所以创建了两个新的对象，地址不同"); //false

        Integer inta1 = new Integer(128);
        Integer inta2 = new Integer(128);
        System.out.println("inta1 == inta2 : " + (inta1 == inta2) + ", Integer inta1和Integer inta2 new 创建" +
                "赋值，当这个值在[-128,127]之间，直接使用缓存值， 是同一个对象，但是在这个范围之外， 就需要创建新的对象了，" +
                "128刚好在之外，虽然上面已经调用过了128， 但是没什么用，还是要创建新对象，所以创建了两个新的对象，地址不同"); //false


    }
}
