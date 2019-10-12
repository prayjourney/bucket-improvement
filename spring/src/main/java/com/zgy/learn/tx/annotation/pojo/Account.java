package com.zgy.learn.tx.annotation.pojo;

import org.springframework.stereotype.Component;

/**
 * @Author: renjiaxin
 * @Despcription: POJO类， Account账户
 * @Date: Created in 2019/10/13 1:06
 * @Modified by:
 */
@Component(value = "account")
public class Account {
    private int id;
    private String name;
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
