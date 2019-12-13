package com.zgy.learn.bootcrud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-12-13 01:01
 * @Modified by:
 */
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("hello")
    public String helloController() {
        logger.debug("访问方法： {0}", "helloController");
        return "hello boot crud!";
    }
}
