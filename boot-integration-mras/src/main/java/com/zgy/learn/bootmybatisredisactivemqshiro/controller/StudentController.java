package com.zgy.learn.bootmybatisredisactivemqshiro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zgy.learn.bootmybatisredisactivemqshiro.pojo.Student;
import com.zgy.learn.bootmybatisredisactivemqshiro.service.StudentService;
import com.zgy.learn.bootmybatisredisactivemqshiro.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/4/21 1:01
 * @Modified by:
 */
@Slf4j
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService service;

    @RequestMapping("getonestudent")
    @ResponseBody
    public String getonestudent(Integer stId) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.getStudentById(stId));
    }

    @RequestMapping("getallstudent")
    @ResponseBody
    public String getallstudent() throws JsonProcessingException {
        log.info("获取全部的学生，时间是{}" + LocalDateTime.now());
        return JSONUtil.getJsonFromObject(service.getAllStudents());
    }

    @RequestMapping(value = "addstudent", method = RequestMethod.POST)
    @ResponseBody
    public String addstudent(Student student) throws JsonProcessingException {
        log.info("添加了学生 {}", student);
        return JSONUtil.getJsonFromObject(service.addStudent(student));
    }

    @RequestMapping(value = "deletestudent", method = RequestMethod.POST)
    @ResponseBody
    public String deleteStudentById(Integer stId) {
        Integer res = service.deleteStudentById(stId);
        log.info("delete的结果: {}, id是{}！", res, stId);
        return res >= 1 ? "删除成功！" : "删除失败！";
    }

    @RequestMapping(value = "updatestudent", method = RequestMethod.POST)
    @ResponseBody
    public String updateStudentById(Student student) {
        Integer res = service.updateStudentById(student);
        log.info("update的结果: {}, id是{}！", res, student.getStId());
        return res >= 1 ? "更新成功！" : "更新失败！";
    }

    @RequestMapping("getonestudentbasicinfo")
    @ResponseBody
    public String getonestudentbasicinfo(Integer stId) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.studentBasicInfo(stId));
    }

    @RequestMapping("getonestudentimportantinfo")
    @ResponseBody
    public String getonestudentimportantinfo(Integer stId) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.studentImportantInfo(stId));
    }

    @RequestMapping(value = "getstudentbynamegender", method = RequestMethod.POST)
    @ResponseBody
    public String getStudentByNameGender(@RequestParam("stName") String stName, @RequestParam("stGender") String stGender) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("stName", "%" + stName + "%"); // like模糊查询
        map.put("stGender", stGender);
        return JSONUtil.getJsonFromObject(service.getStudentByNameGender(map));
    }

    @RequestMapping(value = "getstudentbynamegender2", method = RequestMethod.POST)
    @ResponseBody
    public String getStudentByNameGender2(@RequestParam("stName") String stName, @RequestParam("stGender") String stGender) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("stName", "%" + stName + "%"); // like模糊查询
        map.put("stGender", stGender);
        return JSONUtil.getJsonFromObject(service.getStudentByNameGender2(map));
    }
}
