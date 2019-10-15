package com.zgy.learn.java8.lambda;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * 使用定制的方法，对List排序
 */
public class EmpLambda {
    List<Employee> emps = CommonUseData.emps;

    @Test
    public void test() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge())
                return e1.getName().compareTo(e2.getName());
            else return -Integer.compare(e1.getAge(), e2.getAge());
        });
        for (Employee e : emps) {
            System.out.println(e);
        }

    }
}
