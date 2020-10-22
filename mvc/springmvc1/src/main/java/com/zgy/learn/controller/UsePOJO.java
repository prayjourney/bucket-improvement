package com.zgy.learn.controller;

import com.zgy.learn.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-04 15:57
 * @Modified by:
 */
@Controller
public class UsePOJO {
    @RequestMapping(value = "/mvc/pojo")
    public String testPojo(ModelMap map, Student student) {
        System.out.println("Spring MVC可以自动关联级联属性, POJO直接使用!");
        map.addAttribute("student", student);
        return "pojo";
    }
}
