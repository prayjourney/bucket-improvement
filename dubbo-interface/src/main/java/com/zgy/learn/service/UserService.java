package com.zgy.learn.service;

import com.zgy.learn.bean.UserAddress;

import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/1/2 1:04
 * @Modified by:
 */
public interface UserService {

    /**
     * 按照用户id返回所有的收货地址
     *
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);

}