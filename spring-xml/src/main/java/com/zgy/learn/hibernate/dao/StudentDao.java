package com.zgy.learn.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/27 16:29
 * @Modified by:
 */
@Repository
public class StudentDao {
    @Autowired
    private SessionFactory sessionFactory;

    // 获取和当前线程绑定的session
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public int findStudentNameById(int id) {
        return 0;

    }

}
