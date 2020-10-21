package com.zgy.learn.bootswaggermailquartzmongoredis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zgy.learn.bootswaggermailquartzmongoredis.util.JSONUtils;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/4/13 22:01
 * @Modified by:
 */
@Api(value = "TeacherController", tags = "教师的Controller")
@Controller
public class TeacherController {
    @RequestMapping("helloteacher")
    @ResponseBody
    public String helloTeacher() throws JsonProcessingException {
        return JSONUtils.getJsonFromObject("hello teacher");
    }
}
