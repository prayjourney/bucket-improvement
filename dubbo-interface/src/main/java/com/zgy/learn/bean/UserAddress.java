package com.zgy.learn.bean;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/1/2 1:03
 * @Modified by:
 */

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户地址
 *
 * @author lfy
 */
@Data
@Builder
public class UserAddress implements Serializable {
    private Integer id;
    // 用户地址
    private String userAddress;
    // 用户id
    private String userId;
    // 收货人
    private String consignee;
    // 电话号码
    private String phoneNum;
    // 是否为默认地址    Y-是     N-否
    private String isDefault;

    public UserAddress() {
        super();
    }

    public UserAddress(Integer id, String userAddress, String userId, String consignee, String phoneNum,
                       String isDefault) {
        super();
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.isDefault = isDefault;
    }
}
