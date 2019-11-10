package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.GirlDao;
import com.zgy.learn.crud.entities.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @Autowired
    GirlDao girlDao;

    // 获得所有女孩
    @RequestMapping("all")
    public String  getAllGirl(Map<String, Object> mp){
        mp.put("allgirl", girlDao.getGrils());
        System.out.println(girlDao.getGrils().size());
        for (Girl g: girlDao.getGrils()){
            g.toString();
        }
        System.out.println("hello");
        return "listallgirl";
    }


    // 添加一个女孩, 跳转到页面
    @RequestMapping(value = "addgirl", method = RequestMethod.GET)
    public String addGirl(){
        return "addgirl";
    }


    // 添加一个女孩
    @RequestMapping(value = "addgirl", method = RequestMethod.POST)
    public String addGirl(String name, Integer age, String size){
        girlDao.addGirl(name, age, size);
        return "redirect:/girl/all";
    }


}
