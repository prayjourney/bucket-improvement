package com.zgy.learn.commontest;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/14 21:27
 * @Modified by:
 */
public class CollectionsTest {
    public static void main(String[] args) {
        String[] ss = new String[]{"1", "hello", "stringss", "japan", "热带雨林", "3CM"};
        List a = new ArrayList();
        // 这个是java.util之中的方法，主要用的就是asList, sort, parallelSort,
        // binarySearch, parallelSearch 以及stream的方法。
        List<String> strings = Arrays.asList(ss);
        a.add(strings);

        // 这个是java.util之中的方法，主要常用的就是max,min,synchronizedSet,synchronizedMap, list
        // sort, binarySearch, reverse, reverseOrder等方法，这个用的挺多的。
        Collections.sort(a);
        for (Object s: a){
            System.out.print(s);
        }
        System.out.println("\n");
        // 这个是org.apache.commons.collections4的方法，主要用isNotEmpty，subtract，
        // filter, select, collect等方法，没有org.apache.commons.lang3用的广泛感觉上。
        System.out.println(CollectionUtils.isNotEmpty(a));
    }
}
