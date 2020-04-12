package com.zgy.learn.bootswagger.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zgy.learn.bootswagger.pojo.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/4/13 3:11
 * @Modified by:
 */
@RestController
@RequestMapping("/swagger")
public class TestPutDelete {
    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "张三", "男", "13111981123"));
        students.add(new Student(2, "李四", "男", "13236981123"));
        students.add(new Student(3, "王五", "男", "13676981123"));
        students.add(new Student(4, "赵柳", "女", "131869812341"));
        students.add(new Student(5, "海翔", "男", "15986981145"));
        students.add(new Student(6, "Jason", "男", "14486981123"));
        students.add(new Student(7, "mari kite", "男", "13186981123"));
        students.add(new Student(8, "李俊和", "男", "17955581123"));
        students.add(new Student(9, "马大三", "男", "158869814443"));
        students.add(new Student(10, "小田纯一郎", "男", "18765981123"));
    }

    // 所有学生
    @RequestMapping(value = "/getallstudent", method = RequestMethod.GET)
    public String getAllStudents() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(students);

    }

    // 删除一个学生
    @DeleteMapping(value = "/deletestudent")
    public String deleteOneById(@RequestParam("id") String id) throws JsonProcessingException {
        ArrayList<Integer> list = new ArrayList<>();
        List<Student> newStudents = new ArrayList<>();
        for (Student s : students) {
            list.add(s.getId());
        }
        if ("" == id || null == id) {
            return "error!";
        }
        if (list.contains(id)) {
            list.remove(id);
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId() != Integer.valueOf(id)) {
                    newStudents.add(students.get(i));
                }
            }
            students = null;
            students = newStudents;
            return new ObjectMapper().writeValueAsString(students);
        } else {
            return "没有这个学生！";
        }
    }
}
