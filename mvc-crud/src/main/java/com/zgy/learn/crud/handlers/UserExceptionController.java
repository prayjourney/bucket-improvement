package com.zgy.learn.crud.handlers;

import com.zgy.learn.crud.util.UserNameNotMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-12-01 11:52
 * @Modified by:
 */
@Controller
public class UserExceptionController {

    // 业务可能会发生异常
    @RequestMapping(value = "userexception")
    public String testException(@RequestParam("i") Integer i, Map<String, Integer> mpmp) throws
            UserNameNotMatchException {
        System.out.println(i);
        if (i == 13) {
            throw new UserNameNotMatchException();
        }
        mpmp.put("res", 10 / i);
        System.out.println("working...");
        return "arithmeticresult";

    }

    @ResponseStatus(value = HttpStatus.GONE, reason = "NMBZZ")
    @RequestMapping(value = "userexception2")
    public String testException2(@RequestParam("i") Integer i, Map<String, Integer> mpmp) throws
            UserNameNotMatchException {
        System.out.println(i);
        if (i == 6) {
            throw new UserNameNotMatchException();
        }
        mpmp.put("res", 10 / i);
        System.out.println("working...");
        return "arithmeticresult";

    }

    // simpleMappingException, 配置出异常的时候, 转向哪个页面
    @RequestMapping(value = "testsimpleexception")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") Integer i) {
        String[] sss = new String[5];
        System.out.println(sss[i]);
        return "arithmeticresult";
    }


}
