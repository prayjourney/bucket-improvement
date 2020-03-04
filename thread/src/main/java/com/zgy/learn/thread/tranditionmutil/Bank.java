package com.zgy.learn.thread.tranditionmutil;

/**
 * @Author: renjiaxin
 * @Despcription: 在银行取钱
 * @Date: Created in 2020/3/1 23:57
 * @Modified by:
 */
public class Bank extends Thread {
    String name;
    static Account account = new Account("1011", 100.23d);

    Bank(String name) {
        super(name);
    }

    @Override
    public void run() {
        // 使用块的锁定，对于可变对象去锁定
        synchronized (account) {
            try {
                Thread.sleep(10);
                System.out.println("操作人： " + Thread.currentThread().getName());
                account.drawMoney(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Bank bankMe = new Bank("我");
        Bank bankGirl = new Bank("女朋友");
        bankMe.start();
        bankGirl.start();
    }
}

// 账户
class Account {
    private String id;
    private double balance;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    // 取款
    public void drawMoney(double num) {
        if (balance < num) {
            System.out.println("金额不够! 当前金额：" + getBalance());
            return;
        }
        balance -= num;
        System.out.println("取款成功，获得金额： " + num);
    }

    // 存款
    public void deposit(double num) {
        balance += num;
        System.out.println("存款成功，存入金额： " + num);
    }

}

