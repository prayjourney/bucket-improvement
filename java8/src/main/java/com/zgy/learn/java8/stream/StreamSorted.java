package com.zgy.learn.java8.stream;

import com.zgy.learn.java8.lambda.CommonUseData;
import com.zgy.learn.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription: Stream排序
 * @Date: Created in 2019/10/16 3:06
 * @Modified by:
 */
public class StreamSorted {
    /**
     * sorted() 产生一个新流，其中按自然顺序排序
     * sorted(Comparatorcomp) 产生一个新流，其中按比较器顺序排序
     */
    /**
     * 自然排序：Comparable
     * 定制排序：Comparator
     */
    @Test
    public void testStreamSorted() {
        List<Integer> ls = Arrays.asList(1, 12, 32, 4, 55, 3, -3, 99, 2);
        ls.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void testStreamSortedComparator() {
        List<Employee> employees = CommonUseData.emps;
        employees.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getSalary() - e2.getSalary();
            } else {
                return e1.getAge() - e2.getAge();
            }
        }).forEach(System.out::println);

    }
}
