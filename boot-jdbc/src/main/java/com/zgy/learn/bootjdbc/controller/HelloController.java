package com.zgy.learn.bootjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/19 0:44
 * @Modified by:
 */
@Controller
public class HelloController {
    @Autowired
    JdbcTemplate template;

    @ResponseBody
    @GetMapping("/query")
    public Map<String, Object> dataMap() {
        List<Map<String, Object>> maps = template.queryForList("SELECT * FROM department");
        // return maps.get(0);
        maps.set(0, new HashMap<String, Object>(1, 122));
        return maps.get(0);

    }
}
