package com.zgy.learn.bootcrud.controller;

import com.zgy.learn.bootcrud.dao.DepartmentDao;
import com.zgy.learn.bootcrud.dao.EmployeeDao;
import com.zgy.learn.bootcrud.entities.Department;
import com.zgy.learn.bootcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public String toAddEmpPage(Model model) {
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

    // 到员工的修改页面
    @GetMapping("emp/{id}")
    public String toUpdateEmpPage(@PathVariable("id") Integer id, Model model){
        // 查出员工，然后回显
        Employee e = dao.get(id);
        model.addAttribute("emp",e);
        // 页面需要显示部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        // 回显(修改和添加页面一致)
        return "emp/add";

    }

    // 修改员工，需要提交员工的id, 是put请求, 修改
    @PutMapping("emp")
    public String updateEmp(Employee e){
        System.out.println(e.toString());
        // id作为了一个隐藏域提交过来
        dao.save(e);
        // 转发到所有员工的页面
        // return "forward:/emps"; // 这个有问题， 无法达到目的
        return "redirect:/emps";
    }

    // 删除员工
    @DeleteMapping("emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        dao.delete(id);
        return "redirect:/emps";

    }

}
