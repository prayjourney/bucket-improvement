package com.zgy.learn.hibernate;

import com.zgy.learn.hibernate.entity.MyBook;
import com.zgy.learn.hibernate.entity2.Teacher;
import com.zgy.learn.hibernate.service.TeacherService;
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
    }

    @Test
    public void testDataSource2() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testFindTeacherById() {
        TeacherService ts = (TeacherService) ctx.getBean("teacherService");
        int no = ts.findTeacherNameById(1);
        System.out.println(no);
    }

    @Test
    public void testUpdateTeacherById() {
        TeacherService ts = (TeacherService) ctx.getBean("teacherService");
        ts.updateTeacherNameById(1, "xxx");
    }

}