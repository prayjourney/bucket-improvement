package com.zgy.learn.feature;

/**
 * @Author: renjiaxin
 * @Despcription: -128到127之间的数字，会有缓存
 * @Date: Created in 2019/12/18 22:14
 * @Modified by:
 */
public class AboutInteger {
    public static void main(String[] args) {
        int int1 = 12;
        int int2 = 12;
        Integer Integer1 = new Integer(12);
        Integer Integer2 = new Integer(12);


        Integer a1 = 127;
        Integer b1 = 127;
        Integer Integer3 = new Integer(127);

        Integer a = 128;
        Integer b = 128;


        System.out.println("int1==int2:" + (int1 == int2));                    //true
        // Integer会自动拆箱为int，所以为true
        System.out.println("int1==Integer1:" + (int1 == Integer1));            //true
        // 不同对象，在内存存放地址不同，所以为false
        System.out.println("Integer1==Integer2:" + (Integer1 == Integer2));    //false
        // Integer3指向new的对象地址，b1指向缓存中127地址，地址不同，所以为false
        // Integer b1 = 127;java在编译的时候,被翻译成-> Integer b1 = Integer.valueOf(127);
        /*[-128,127]之间的范围，包括两端
        public static Integer valueOf(int i) {
            if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
                return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
            return new Integer(i);
        }
        */
        // 对于-128到127之间的数，会进行缓存，Integer b1 = 127时，会将127进行缓存，
        // 下次再写Integer i6 = 127时，就会直接从缓存中取，就不会new了。所以a1==b1:true  a==b:false
        System.out.println("Integer3==b1:" + (Integer3 == b1));                //false
        System.out.println("a1==b1:" + (a1 == b1));                            //true
        System.out.println("a==b:" + (a == b));                                //false
    }
}
