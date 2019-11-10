package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.GirlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

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
        return "listallgirl";
    }


}
