package com.zgy.learn.service.iml;

import com.zgy.learn.bean.UserAddress;
import com.zgy.learn.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription: UserService的实现类
 * @Date: Created in 2020/1/2 1:11
 * @Modified by:
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImpl.....old...");

        // 模拟数据库的实现
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层",
                "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）",
                "1", "王老师", "010-56253825", "N");
        return Arrays.asList(address1, address2);
    }

}