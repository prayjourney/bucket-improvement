package com.zgy.learn.dubbobootprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/7/5 22:39
 * @Modified by:
 */
@RestController
public class ProviderController {

    @GetMapping(value = {"/", "index", "test"})
    public String testProvider() {
        return "我是服务提供者！";
    }
}
