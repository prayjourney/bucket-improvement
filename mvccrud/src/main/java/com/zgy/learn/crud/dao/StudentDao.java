package com.zgy.learn.crud.dao;

import com.zgy.learn.crud.entities.Student;
import org.springframework.stereotype.Repository;

import javax.swing.text.Keymap;
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
    private static Map<Integer, Student> students =new HashMap<>();
    private static int INITID = 4;
    static {
        students.put(1,new Student("张三",22, "男","3", "三年级",
                "168233@qq.com", "13277891233",LocalDate.of(1997,2,13)));
        students.put(2,new Student("柳无双",27, "女","2", "五年级",
                "kkiwls@qq.com","15978379989",LocalDate.of(1992,6,11)));
        students.put(3,new Student("王晓昭",19, "女","3", "三年级",
                "mbkl@163.com","17923331678",LocalDate.of(2000,11,24)));
    }
    // 获取所有学生
    public Collection<Student> getAllStudent(){
        return students.values();
    }
    // 添加一个学生
    public void addStudent(){

    }

    // 移除一个学生
    public void removeStudent(){

    }
    // 更新一个学生
    public void updateStudent(){

    }
}
