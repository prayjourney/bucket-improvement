package com.zgy.learn.crud.dao;

import com.zgy.learn.crud.entities.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description: studentDao
 * @Date: 2019-11-13 01:43
 * @Modified by:
 */
@Repository
public class StudentDao {
    private static Map<Integer, Student> students = new HashMap<>();
    static int INITID = 4;

    static {
//        students.put(1, new Student(1, "张三", 22, "男", "3", "三年级",
//                "168233@qq.com", "13277891233", LocalDate.of(1997, 2, 13)));
//        students.put(2, new Student(2, "柳无双", 27, "女", "2", "五年级",
//                "kkiwls@qq.com", "15978379989", LocalDate.of(1992, 6, 11)));
//        students.put(3, new Student(3, "王晓昭", 19, "女", "3", "三年级",
//                "mbkl@163.com", "17923331678", LocalDate.of(2000, 11, 24)));
        students.put(1, new Student(1, "张三", 22, "男", "3", "三年级",
                "168233@qq.com", "13277891233", LocalDate.of(1997, 2, 13).toString()));
        students.put(2, new Student(2, "柳无双", 27, "女", "2", "五年级",
                "kkiwls@qq.com", "15978379989", LocalDate.of(1992, 6, 11).toString()));
        students.put(3, new Student(3, "王晓昭", 19, "女", "3", "三年级",
                "mbkl@163.com", "17923331678", LocalDate.of(2000, 11, 24).toString()));
    }

    // 获取所有学生
    public Collection<Student> getAllStudent() {
        return students.values();
    }

    // 添加一个学生
    public void addStudent(Student student) {
        if (student.getId() == null) {
            student.setId(INITID);
        }
        students.put(INITID, student);
        INITID++;
    }

    // 移除一个学生
    public int removeStudent(Integer id) {
        if (null == students.get(id)) {
            System.out.println("没有学生了");
            return 0;
        } else {
            students.remove("id");
            return 1;
        }
    }

    // 更新一个学生
    public void updateStudent() {

    }

    // 获得一个学生
    public Student getStudent(Integer id) {
        return students.get(id);
    }

    public static Map<Integer, Student> getMapStudents() {
        return students;
    }
}
