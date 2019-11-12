package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-13 01:56
 * @Modified by:
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentDao studentDao;

    @RequestMapping("all")
    public String getAllStudent(ModelMap mp) {
        mp.addAttribute("students", studentDao.getAllStudent());
        return "allstudents";
    }
}
