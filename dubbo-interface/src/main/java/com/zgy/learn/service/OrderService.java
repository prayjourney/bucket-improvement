package com.zgy.learn.service;

import com.zgy.learn.bean.UserAddress;

import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/1/2 1:04
 * @Modified by:
 */
public interface OrderService {

    /**
     * 初始化订单
     *
     * @param userId
     */
    public List<UserAddress> initOrder(String userId);

}
