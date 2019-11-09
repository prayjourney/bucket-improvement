package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.DepartmentDao;
import com.zgy.learn.crud.dao.EmployeeDao;
import com.zgy.learn.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description: 添加新员工的页面
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
     * @param model model
     * @return 创建新员工的一个页面
     */
    @RequestMapping(value = "emp", method = RequestMethod.GET)
    public String input(ModelMap model) {
        model.addAttribute("departments", departmentDao.getDepartments());
        // 用于表单的回显, 需要在form里面对应起来, 也就是modelAttribute属性, 默认是command,
        // 修改后就是一个model的名字, 此处是employee

        // 此时, 并没有进行表单回显
        model.addAttribute("employee", new Employee());
        Map<String, String> mp = new HashMap<>();
        mp.put("0", "Male");
        mp.put("1", "Female");
        model.addAttribute("genders", mp.values());
        // 表单的回显?
        return "input";

    }

    /**
     * 完成员工的新创建, get的这个方法只是出现一个页面而已
     * @return list页面
     * // /emp也不行
     */
    @RequestMapping(value = "emp", method = RequestMethod.POST)
    public String save(Employee employee) {
        employeeDao.save(employee);
        // 重定向到显示所有员工的页面, 重定向有问题!!!为何呢?
        return "redirect:/emps";
        // todo: 类型有问题? 加入失败!
        // return "list";
    }

    /**
     * 说明: 此处是要删除我们的数据, 使用restful风格, 但是如果使用了RequestMethod.GET, 则提示不支持
     *      我们需要使用RequestMethod.GET 来代替, 则可以实现
     *      原本的表头: @RequestMapping(value = "/emp/{id}", method = RequestMethod.POST)
     *      https://blog.csdn.net/qq_33522312/article/details/90439730
     * @param id 员工的id
     * @return 剩余员工的页面
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        // 这样进入的一个页面是空的!
        // return "list";
        return  "redirect:/emps";
    }

    /**
     * 处理return list为空的问题
     * @param id 员工的id
     * @return 剩余员工的页面
     */
    @RequestMapping(value = "/emp2/{id}", method = RequestMethod.GET)
    public String delete2(@PathVariable("id") Integer id, ModelMap mp){
        employeeDao.delete(id);
        // 删除完之后, 在获取一遍? 为啥我直接重定向就是okay的呢? 相当于是一个完整的请求?
        // 这就是为了所谓的回显
        // 但是这样, 会让我们的页面出现 http://localhost:8080/emp2/emp2/1004的情况, 这样就会
        // 无法访问, 所以貌似还是直接重定向好一些啊
        mp.put("employees", employeeDao.getAll());
        return "list";
        // <%--"${pageContext.request.contextPath}/emp"--%>
        // https://blog.csdn.net/japson_iot/article/details/79660293 解决这个问题
        // return  "redirect:/emps";
    }


    /**
     * 测试重定向
     * @return 测试重定向
     */
    @RequestMapping(value = "/testredirect", method = RequestMethod.GET)
    public String testRedirect(){
        System.out.println("为了重定向而存在的一个方法!");
        return "redirect:/emps";
    }

    /**
     * 修改员工信息, 可以表单回显
     * @param id id
     * @param map map
     * @return input
     */
    @RequestMapping(value = "emp/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map){
        map.put("employee", employeeDao.get(id));
        map.put("departments", departmentDao.getDepartments());
        return "input";
    }

    @ModelAttribute
    public void getEmployee(@RequestParam(value="id",required=false) Integer id,
                            Map<String, Object> map){
        if(id != null){
            map.put("employee", employeeDao.get(id));
        }
    }

    @RequestMapping(value = "emp", method = RequestMethod.PUT)
    public String update(Employee e){
        employeeDao.save(e);
        return "redirect:/emps";
    }

}
