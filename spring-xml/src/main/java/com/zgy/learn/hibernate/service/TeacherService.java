package com.zgy.learn.hibernate.service;

import com.zgy.learn.hibernate.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/27 16:55
 * @Modified by:
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public int findTeacherNameById(int id) {
        return teacherDao.findTeacherNameById(id);

    }

    public void updateTeacherNameById(int id, String name) {
        teacherDao.updateTeacherNameById(id, "张三");
    }
}
