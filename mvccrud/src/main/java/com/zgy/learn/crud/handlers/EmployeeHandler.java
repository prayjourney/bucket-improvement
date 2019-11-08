package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.DepartmentDao;
import com.zgy.learn.crud.dao.EmployeeDao;
import com.zgy.learn.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-09 03:19
 * @Modified by:
 */
@Controller
public class EmployeeHandler {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 列出所有的员工
     *
     * @param mp 装载员工
     * @return mv
     */
    @RequestMapping("emps")
    public String list(Map<String, Object> mp) {
        mp.put("employees", employeeDao.getAll());
        return "list";
    }

    /**
     * 添加一个新的员工
     *
     * @param mp
     * @return
     */
    @RequestMapping(value = "emp", method = RequestMethod.GET)
    public String input(ModelMap model) {
        model.addAttribute("departments", departmentDao.getDepartments());
        // 用于表单的回显, 需要在form里面对应起来, 也就是modelAttribute属性, 默认是command,
        // 修改后就是一个model的名字, 此处是employee
        model.addAttribute("employee", new Employee());
        Map<String, String> mp = new HashMap<>();
        mp.put("0", "Male");
        mp.put("1", "Female");
        model.addAttribute("genders", mp.values());
        // 表单的回显?
        return "input";

    }
}
