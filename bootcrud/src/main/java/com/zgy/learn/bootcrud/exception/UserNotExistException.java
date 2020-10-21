package com.zgy.learn.bootcrud.exception;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/15 12:31
 * @Modified by:
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
