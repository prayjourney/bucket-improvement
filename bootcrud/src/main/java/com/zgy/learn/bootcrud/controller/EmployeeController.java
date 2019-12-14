package com.zgy.learn.bootcrud.controller;

import com.zgy.learn.bootcrud.dao.EmployeeDao;
import com.zgy.learn.bootcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/14 23:06
 * @Modified by:
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao dao;

    // 查询所有的员工
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> emps = dao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }
}
