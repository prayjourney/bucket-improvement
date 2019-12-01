package com.zgy.learn.crud.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-12-01 10:31
 * @Modified by:
 */
@Controller
public class MyResolverExceptionController {

    // 业务可能会发生异常
    @RequestMapping(value = "testexception")
    public String testException(@RequestParam int i, Map<String, Integer> mpmp) {
        System.out.println(i);
        mpmp.put("res", 10 / i);
        return "arithmeticresult";

    }

    /**
     * 1. 对应的某一种类型的异常, 写到Handler注解之中, 然后出现了异常, 它就会去处理
     * 2. @ExceptionHandlerd的入参之中可以加入 Exception类型 的参数, 该参数对应的是发生异常的对象
     * 3. @ExceptionHandlerd的方法入参之中不能加入map, 如果要给页面返回异常, 那就要使用ModelAndView
     * 4. @ExceptionHandler的方法, 当有多个异常处理器的时候, 总是匹配和异常最相近的异常处理器
     * 5. @ControllerAdvice, 如果在Handler之中找不到@ExceptionHandler方法修饰的方法的话, 那么就要去在
     *    @ControllerAdvice修饰的类之中, 找使用@ExceptionHandler修饰的方法, 优先级的问题还是具体的要大于非具体的
     *    handler之中的具体的大于handler之中非具体的, handler大于@ControllerAdvice, 其实就是一个问题,
     *    仅仅只是使用ExceptionHandler修饰的异常处理方法, 他不是全局的, 所以就要使用@ControllerAdvice的出现
     */
//    @ExceptionHandler({ArithmeticException.class, OutOfMemoryError.class})
//    public ModelAndView handleArithmeticException(Exception ex) {
//        System.out.println("出了异常");
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("errorException", ex);
//        return mv;
//    }

//    @ExceptionHandler({RuntimeException.class})
//    public ModelAndView handleArithmeticException2(Exception ex) {
//        System.out.println("出了异常---------------");
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("errorException", ex);
//        return mv;
//    }
}
