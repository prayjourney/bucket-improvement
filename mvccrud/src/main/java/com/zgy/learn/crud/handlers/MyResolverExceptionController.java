package com.zgy.learn.crud.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-12-01 10:31
 * @Modified by:
 */
@Controller
public class MyResolverExceptionController {

    @RequestMapping(value = "testexception")
    public String testException(@RequestParam int i, Map<String, Integer> mpmp){
        System.out.println(i);
        mpmp.put("res", 10/i);
        return "arithmeticresult";

    }

    @ExceptionHandler
    public String handleArithmeticException(){
        System.out.println("出了异常");
        return "error";
    }
}
