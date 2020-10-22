package com.zgy.learn.bootmybatisredisactivemqshiro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zgy.learn.bootmybatisredisactivemqshiro.service.TeacherService;
import com.zgy.learn.bootmybatisredisactivemqshiro.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService service;

    @RequestMapping("getoneteacher")
    @ResponseBody
    public String getoneteacher(Integer teId) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.getTeacherById(teId));
    }

    @RequestMapping("getallteacher")
    @ResponseBody
    public String getallteacher() throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.getAllTeachers());
    }

    /**
     * 使用map传值
     */
    @RequestMapping("getteacherbynamegender")
    @ResponseBody
    public String getteachernamegender(String name, String gender) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("teName", name);
        map.put("teGender", gender);
        return JSONUtil.getJsonFromObject(service.getTeacherByNameAndGender(map));
    }

    /**
     * pageSize和page, 分页
     */
    @RequestMapping("getteacherbywithpage")
    @ResponseBody
    public String getteacherbywithpage(Integer teId, Integer page, Integer pageSize) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.getTeacherWithPage(teId, page, pageSize));
    }
}
