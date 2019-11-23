package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.StudentDao;
import com.zgy.learn.crud.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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

    @ModelAttribute
    public void addNewStudent(Integer id, Map<String, Object> map) {
        if (id != null) {
            map.put("student", new Student());
        }
    }


    // 新建的一个student, 用来装form表单里面组装好的对象
    @ModelAttribute("student")
    public Student getStudent() {
        System.out.println("------getStudent()-----");
        return new Student();
    }


    // ModelAttribute方法是在所有的Controller之中的方法之前运行的, 所以此处就会需要一个ID, 而我们没有id, 那就会报错的!
    // 返回一个已经有了值得对象
    /*@ModelAttribute
     public Student upOrDeleteStudent(@RequestParam Integer id) {
        return studentDao.getMapStudents().get(id);
    }
    */

    @RequestMapping("addstudent")
    public String addStudent() {
        return "addstudent";
    }

    @RequestMapping(value = "addstudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student) {
        studentDao.addStudent(student);
        return "redirect:/student/all";
    }

    //    @RequestMapping(value = "deletestudent?id={id}", method = RequestMethod.DELETE)
    @RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Integer id) {
        int result = studentDao.removeStudent(id);
        System.out.println(String.format("已经删除%d个学生", result));
        return "redirect:/student/all";
    }
//    @RequestMapping(value = "deletestudent/{id}", method = RequestMethod.GET)
//    public String deleteStudent(@PathVariable Integer id) {
//        int result = studentDao.removeStudent(id);
//        System.out.println(String.format("已经删除%d个学生", result));
//        return "redirect:/student/all";
//    }

}
