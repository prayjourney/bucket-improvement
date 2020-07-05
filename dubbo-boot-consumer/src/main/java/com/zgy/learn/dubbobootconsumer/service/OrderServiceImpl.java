package com.zgy.learn.dubbobootconsumer.service;

import com.zgy.learn.bean.UserAddress;
import com.zgy.learn.service.OrderService;
import com.zgy.learn.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription: 这个reference是表示引用到了其他的对象提供的service，此处是服务消费者，我们使用到了用户服务
 * @Date: Created in 2020/1/2 1:12
 * @Modified by:
 */

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 1）、导入dubbo依赖（2.7.x）\操作zookeeper的客户端(curator)
 * 2）、配置服务提供者
 * <p>
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {
    // 使用远程接口
    @Reference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id：" + userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress.getUserAddress());
        }
        return addressList;
    }
}
