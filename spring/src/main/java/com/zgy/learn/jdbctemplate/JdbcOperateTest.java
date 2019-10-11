package com.zgy.learn.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: renjiaxin
 * @Despcription: JDBC的操作
 * @Date: Created in 2019/10/12 0:06
 * @Modified by:
 */
public class JdbcOperateTest {
    ApplicationContext context = null;
    private static JdbcTemplate jdbcTemplate;

    {
        context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }


    public static void main(String[] args) {
        String sqlInsert = "insert into employee(name,age,salary) values (?, ?, ?)";
        jdbcTemplate.update(sqlInsert, "赵四", 38, 8000);
    }
}
