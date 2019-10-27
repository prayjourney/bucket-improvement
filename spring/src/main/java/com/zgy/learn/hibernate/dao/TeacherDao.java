package com.zgy.learn.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/27 16:29
 * @Modified by:
 */
@Repository
public class TeacherDao {

    @Autowired
    private SessionFactory sessionFactory;

    // 获取和当前线程绑定的session
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public int findTeacherNameById(int id) {
        String sql = "select tid, name, gender from  tb_teacher where tid =?";
        Query query = getSession().createQuery(sql).setInteger(0, id);
        return (int) query.uniqueResult();
    }

    public void updateTeacherNameById(int id, String name) {
        String sql = "update tb_teacher set name = ? where tid = ?";
        getSession().createQuery(sql).setInteger(0, id).setString(1, name).executeUpdate();
    }
}
