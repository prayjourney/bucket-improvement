package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.dao.MonkeyDao;
import com.zgy.learn.crud.entities.Monkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-24 03:29
 * @Modified by:
 */
@Controller
public class MonkeyJsonController {
    @Autowired
    MonkeyDao dao;

    @ResponseBody
    @RequestMapping("/monkeyjson/{id}")
    public Monkey hello2(@PathVariable Integer id) {
        return dao.get(id);
    }

}