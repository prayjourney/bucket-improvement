package com.zgy.learn.commontest;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @Author: renjiaxin
 * @Despcription: 测试一个字符串是不是数字, 带-号的都不认为是数字
 * @Date: Created in 2020/2/14 18:57
 * @Modified by:
 * @URL: https://www.cnblogs.com/pengzp97/p/10286435.html
 */
public class StringIsNumber {

    public static void main(String[] args) {
        System.out.println("=======================strIsNum01=======================");
        System.out.println(strIsNum01("123"));
        System.out.println(strIsNum01("1123123pp23"));
        System.out.println(strIsNum01("123:"));
        System.out.println(strIsNum01("tt123:"));
        System.out.println(strIsNum01("t*123:"));
        System.out.println(strIsNum01("-123:"));

        System.out.println("=======================strIsNum02=======================");
        System.out.println(strIsNum02("123"));
        System.out.println(strIsNum02("1123123pp23"));
        System.out.println(strIsNum02("123:"));
        System.out.println(strIsNum02("tt123:"));
        System.out.println(strIsNum02("t*123:"));
        System.out.println(strIsNum02("-123:"));

        System.out.println("=======================strIsNum03=======================");
        System.out.println(strIsNum03("123"));
        System.out.println(strIsNum03("1123123pp23"));
        System.out.println(strIsNum03("123:"));
        System.out.println(strIsNum03("tt123:"));
        System.out.println(strIsNum03("t*123:"));
        System.out.println(strIsNum03("-123:"));
    }
    // org.apache.commons.lang3.StringUtils.isNumeric方法
    public static boolean strIsNum01(String str) {
        return StringUtils.isNumeric(str);
    }

    // 使用正则表达式
    public static boolean strIsNum02(String str) {
        String patternStr = "^[0-9]{1,}$";
        Pattern p = Pattern.compile(patternStr);
        return p.matcher(str).matches();
    }

    // Character.isDigit()方法，循环
    public static boolean strIsNum03(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
