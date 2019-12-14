package com.zgy.learn.bootcrud.controller;

import com.zgy.learn.bootcrud.dao.DepartmentDao;
import com.zgy.learn.bootcrud.dao.EmployeeDao;
import com.zgy.learn.bootcrud.entities.Department;
import com.zgy.learn.bootcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @Autowired
    DepartmentDao departmentDao;

    // 查询所有的员工
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> emps = dao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }

    // 到员工添加页面
    @RequestMapping(value = "emp", method = RequestMethod.GET)
    public String addEmp(Model model) {
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";

    }

    // springmvc 自动将请求入参和入参对象的属性一一绑定，要求请求入参和javabean的属性名一致
    @PostMapping("emp")
    public String addEmp(Employee e){
        dao.save(e);
        // redirect：重定向到一个地址， /代表当前项目路径
        // forward：转发到一个地址
        return "redirect:/emps";
    }


}
