package com.zgy.learn.commontest;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/14 21:16
 * @Modified by:
 */
public class StringEmptyOrBlank {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = " hello";
        String str3 = new String();
        String str4 = "";
        String str5 = " ";
        System.out.println("====== Empty表示为空，没有占一个位置就是空 ======");
        // Empty表示为空，没有占一个位置就是空
        System.out.println(str1 + ": StringUtils.isEmpty: " + StringUtils.isEmpty(str1));
        System.out.println(str2 + ": StringUtils.isEmpty: " + StringUtils.isEmpty(str2));
        System.out.println(str3 + ": StringUtils.isEmpty: " + StringUtils.isEmpty(str3));
        System.out.println(str4 + ": StringUtils.isEmpty: " + StringUtils.isEmpty(str4));
        System.out.println(str5 + ": StringUtils.isEmpty: " + StringUtils.isEmpty(str5));

        System.out.println("====== Blank表示空白， 有具体的字符显示出来就不是空白，\" \" 这就是空白, 空白包括null 和空! ======");
        // Blank表示空白， 有具体的字符显示出来就不是空白，" " 这就是空白
        System.out.println(str1 + ": StringUtils.isEmpty: " + StringUtils.isBlank(str1));
        System.out.println(str2 + ": StringUtils.isBlank: " + StringUtils.isBlank(str2));
        System.out.println(str3 + ": StringUtils.isBlank: " + StringUtils.isBlank(str3));
        System.out.println(str4 + ": StringUtils.isBlank: " + StringUtils.isBlank(str4));
        System.out.println(str5 + ": StringUtils.isBlank: " + StringUtils.isBlank(str5));
    }
}
