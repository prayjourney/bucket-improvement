package com.zgy.learn.dubbobootprovider.service;

import com.zgy.learn.bean.UserAddress;
import com.zgy.learn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription: UserService的实现类, 这是一个实现类，对外提供服务, 使用的是dubbo的service
 * @Date: Created in 2020/1/2 1:11
 * @Modified by:
 */
@Slf4j
@Service(version = "2.0", timeout = 1000)
public class UserServiceImpl02 implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        log.info("UserServiceImpl.....version: 2.0");

        // 模拟数据库的实现
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层",
                "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）",
                "2", "王老师", "010-56253825", "N");
        UserAddress address3 = new UserAddress(2, "成都市青羊区航天科技大厦B座",
                "3", "张老师", "13324563489", "N");
        return Arrays.asList(address1, address2, address3);
    }
}