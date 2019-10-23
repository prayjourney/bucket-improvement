package com.zgy.learn.hibernate;

import com.zgy.learn.hibernate.entity.MyBook;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/24 2:02
 * @Modified by:
 */
public class HibernateTest {
    private ApplicationContext ctx = null;

    {
        ctx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
        MyBook book = new MyBook();
        book.setId(2);
        book.setBookName("Java程序设计");
        book.setPrice(48);
        book.setStock(78);
        book.setIsbn("ISBN-001-0980");
    }
    @Test
    public void  testSetBook() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        MyBook book = new MyBook();
        book.setId(2);
        book.setBookName("Java程序设计");
        book.setPrice(48);
        book.setStock(78);
        book.setIsbn("ISBN-001-0980");
    }

}