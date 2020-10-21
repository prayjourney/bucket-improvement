package com.zgy.learn.crud.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: renjiaxin
 * @Description: 自定义一个异常, 同时定制了我们的异常信息
 * @Date: 2019-12-01 11:43
 * @Modified by:
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户名不匹配")
public class UserNameNotMatchException extends Exception {


}
