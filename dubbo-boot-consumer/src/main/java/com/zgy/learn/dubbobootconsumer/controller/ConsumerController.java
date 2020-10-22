package com.zgy.learn.dubbobootconsumer.controller;

import com.zgy.learn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/7/5 22:35
 * @Modified by:
 */
@RestController
public class ConsumerController {
    @Autowired
    OrderService orderService;

    @GetMapping(value = {"/", "index", "test"})
    public String testConsumer() {
        return "hello world!";
    }

    @GetMapping("consumer")
    public String testOrderConsumer() {
        return orderService.initOrder("10").toString();
    }
}
