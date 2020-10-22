package com.zgy.learn.bootmybatisredisactivemqshiro.service;

import com.zgy.learn.bootmybatisredisactivemqshiro.mapper.StudentMapper;
import com.zgy.learn.bootmybatisredisactivemqshiro.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/4/21 1:03
 * @Modified by:
 */
@Service
public class StudentService {
    @Autowired(required = false)
    StudentMapper mapper;

    public Student getStudentById(Integer stId) {
        return mapper.getStudentById(stId);
    }

    public List<Student> getAllStudents() {
        return mapper.getAllStudents();
    }

    public Student addStudent(Student student) {
        mapper.addStudent(student);
        return student;
    }

    public Integer deleteStudentById(Integer stId) {
        return mapper.deleteStudentById(stId);
    }

    public Integer updateStudentById(Student student) {
        return mapper.updateStudentById(student);

    }

    // 目的是为了返回部分的信息, 但是直接返回不得行，还是要自己处理一下, 如下是可以的。
    // public Student studentBasicInfo(Integer stId) {
    //     Student student = mapper.studentBasicInfo(stId);
    //     return student;
    public Map studentBasicInfo(Integer stId) {
        Student student = mapper.studentBasicInfo(stId);
        Map<String, Object> map = new HashMap<>();
        map.put("stId", student.getStId());
        map.put("stName", student.getStName());
        map.put("stGender", student.getStGender());
        map.put("stClass", student.getStClass());
        return map;
    }

    public Map<String, Object> studentImportantInfo(Integer stId) {
        Map<String, Object> mp = mapper.studentImportantInfo(stId);
        return mp;
    }

    public Map getStudentByNameGender(Map<String, Object> map) {
        Map<String, Object> resultMp = new HashMap<>();
        resultMp = mapper.getStudentByNameGender(map);
        System.out.println(resultMp);
        return resultMp;
    }

    public List<Student> getStudentByNameGender2(Map<String, Object> map) {
        return mapper.getStudentByNameGender2(map);
    }
}
