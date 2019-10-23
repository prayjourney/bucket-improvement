package com.zgy.learn.hibernate.entity;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/24 1:51
 * @Modified by:
 */
public class MyAccount {
    private Integer id;
    private String username;
    private int balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
