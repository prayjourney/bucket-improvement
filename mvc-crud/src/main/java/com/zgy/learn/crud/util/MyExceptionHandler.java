package com.zgy.learn.crud.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: renjiaxin
 * @Description: 使用@ExceptionHandler修饰的方法, 只能处理对应的几种异常, 我现在要处理各种异常, 那就写一个单独的类处理
 * @Date: 2019-12-01 11:22
 * @Modified by:
 */
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleException(Exception ex) {
        System.out.println("----------->出了异常");
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorException", ex);
        return mv;
    }
}
