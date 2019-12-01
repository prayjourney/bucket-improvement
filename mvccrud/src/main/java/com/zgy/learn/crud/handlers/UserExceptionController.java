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

}
