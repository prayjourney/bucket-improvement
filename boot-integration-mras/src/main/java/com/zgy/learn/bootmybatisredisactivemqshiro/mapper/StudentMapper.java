package com.zgy.learn.bootmybatisredisactivemqshiro.mapper;

import com.zgy.learn.bootmybatisredisactivemqshiro.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    public List<Student> getAllStudents();

    public Integer addStudent(Student student);

    public Student getStudentById(Integer stId);

    public Integer deleteStudentById(Integer stId);

    public Integer updateStudentById(Student student);

    public Student studentBasicInfo(Integer stId);

    public Map<String, Object> studentImportantInfo(Integer stId);

    // 返回一个map的类型, 接收一个map的类型
    public Map getStudentByNameGender(Map<String, Object> map);

    // 返回一个或多个的对象，放在list之中
    public List<Student> getStudentByNameGender2(Map<String, Object> map);
}
