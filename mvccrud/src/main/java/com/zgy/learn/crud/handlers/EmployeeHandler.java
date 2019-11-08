package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("emps")
    public String list(Map<String, Object> mp){
        mp.put("employees",employeeDao.getAll());
        return "list";

    }
}
