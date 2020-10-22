package com.zgy.learn.bootcrud.dao;

import com.zgy.learn.bootcrud.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "销售部"));
        departments.put(102, new Department(102, "客服部"));
        departments.put(103, new Department(103, "云计算"));
        departments.put(104, new Department(104, "5G实验室"));
        departments.put(105, new Department(105, "需求管理"));
    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public Department getDepartment(Integer id) {
        return departments.get(id);
    }

}
