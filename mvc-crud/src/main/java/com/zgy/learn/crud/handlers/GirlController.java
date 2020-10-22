package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.GirlDao;
import com.zgy.learn.crud.entities.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-11 03:07
 * @Modified by:
 */
@Controller
@RequestMapping(value = "girl")
public class GirlController {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    GirlDao girlDao;

    // 获得所有女孩
    @RequestMapping("all")
    public String getAllGirl(Map<String, Object> mp) {
        mp.put("allgirl", girlDao.getGrils());
//        System.out.println(girlDao.getGrils().size());
//        for (Girl g: girlDao.getGrils()){
//            g.toString();
//        }
        System.out.println("hello");
        return "listallgirl";
    }


    // 添加一个女孩, 跳转到页面
    @RequestMapping(value = "addgirl", method = RequestMethod.GET)
    public String addGirl() {
        return "addgirl";
    }


    //    // 添加一个女孩
//    @RequestMapping(value = "addgirl", method = RequestMethod.POST)
//    // 这些name age size为空 ,这是因为form之中没有给我们的入参传值,
//    // form 之中必须要加上name属性, 这个name属性要和我们POJO之中的字段名称对应起来, 否则就会报错!
//    public String addGirl(String name, Integer age, String size){
//        girlDao.addGirl(name, age, size);
//        // 下面的这个写死的方式, 必然添加成功一个girl
//        // girlDao.addGirl("12312312", 22, "E");
//        System.out.println("add...");
//        return "redirect:/girl/all";
//    }
    // 添加一个女孩, 加入了数值的验证
    // BindingResult来捕获转换错误的消息, 错误的信息保存在BindingResult之中
    @RequestMapping(value = "addgirl", method = RequestMethod.POST)
    public String addGirl(String name, Integer age, String size, String birth, Float salary) {
        girlDao.addGirl(name, age, size, birth, salary);
        System.out.println("add...");
        return "redirect:/girl/all";
    }


//    @RequestMapping(value = "addgirl", method = RequestMethod.POST)
//    public String addGirl2(@Valid Girl girl, BindingResult result){
//        girlDao.addGirl(girl.getName(), girl.getAge(), girl.getSize(),girl.getBirth().toString(), girl.getSalary());
//        System.out.println("add...");
//        // BindingResult来捕获转换错误的消息
//        if (result.getErrorCount()>0){
//            System.out.println("出错了...");
//            for (FieldError error: result.getFieldErrors()) {
//                System.out.println(error.getField() +" : " + error.getDefaultMessage());
//            }
//        }
//        return "redirect:/girl/all";
//    }


    @RequestMapping(value = "deletegirl", method = RequestMethod.DELETE)
    public String deleteGirl(Integer id) {
        girlDao.deleteGirl(id);
        System.out.println("delete...");
        return "redirect:/girl/all";
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        // 指定什么格式，前台传什么格式
        sdf.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }


}
