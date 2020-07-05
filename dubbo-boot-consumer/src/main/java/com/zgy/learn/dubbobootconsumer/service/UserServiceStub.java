package com.zgy.learn.dubbobootconsumer.service;

import com.zgy.learn.bean.UserAddress;
import com.zgy.learn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/7/6 0:59
 * @Modified by:
 */
@Component
@Slf4j
public class UserServiceStub implements UserService {
    private final UserService userService;

    // 构造函数传入真正的远程代理对象
    public UserServiceStub(UserService userService) {
        super();
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        log.info("本地存根被调用！");
        if (!StringUtils.isEmpty(userId)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
