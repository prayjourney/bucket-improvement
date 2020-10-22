package com.zgy.learn.bootmybatisredisactivemqshiro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zgy.learn.bootmybatisredisactivemqshiro.service.CityService;
import com.zgy.learn.bootmybatisredisactivemqshiro.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/4/26 23:36
 * @Modified by:
 */
@RestController
@RequestMapping("city")
public class CityController {
    @Autowired
    CityService service;

    @GetMapping("getSouvenir")
    public String getSouvenirByName(String soName) throws JsonProcessingException {
        return JSONUtil.getJsonFromObject(service.getSouvenirByName(soName));
    }
}
