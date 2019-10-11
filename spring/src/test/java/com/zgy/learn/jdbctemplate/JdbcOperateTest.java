package com.zgy.learn.jdbctemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/12 0:48
 * @Modified by:
 */

public class JdbcOperateTest {
    ApplicationContext context = null;
    private static JdbcTemplate jdbcTemplate;

    {
        context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    /**
     * update 执行insert, update, delete
     */
    @Test
    public void testUpdate() {
        String sqlInsert = "insert into employee(name,age,salary) values (?, ?, ?)";
        jdbcTemplate.update(sqlInsert, "赵四", 38, 8000);
    }

    @Test
    public void testDelete() {
        String sqlDelete = "delete from employee where id = ?";
        jdbcTemplate.update(sqlDelete, 7);
    }

    @Test
    public void testBatchUpdate() {
        String insertBatch = "insert into employee(name, age, salary) values(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"马云", 52, 900000});
        batchArgs.add(new Object[]{"马化腾", 49, 800000});
        batchArgs.add(new Object[]{"李彦宏", 41, 300000});
        batchArgs.add(new Object[]{"刘强东", 52, 400000});
        // 返回执行结果， 1表示成功
        int[] s = jdbcTemplate.batchUpdate(insertBatch, batchArgs);
        String info = String.format("%d, %d, %d, %d", s[0], s[1], s[2], s[3]);
        System.out.println(info);
    }
}
