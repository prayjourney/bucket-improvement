package com.zgy.learn.tx.annotation.service;

import com.zgy.learn.tx.annotation.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: renjiaxin
 * @Despcription: AccountService
 * @Date: Created in 2019/10/13 1:07
 * @Modified by:
 */
@Service(value = "accountService")
public class AccountService {
    @Autowired
    AccountDao accountDao;

    /**
     * 检查是否有这个账户
     *
     * @param id id
     * @return false没有此id, true有此账户
     */
    public boolean checkID(int id) {
        boolean s = accountDao.checkID(id);
        return s;
    }

    /**
     * 通过id获取余额
     *
     * @param id id
     * @return 余额
     */
    public double getBalance(int id) {
        double balance = accountDao.getBalance(id);
        return balance;
    }

    /**
     * 更新余额
     *
     * @param id
     * @param nu
     */
    public void updateBalance(int id, double nu) {
        accountDao.updateBalance(id, nu);
    }

    /**
     * 为购买的书，付钱，余额和总的金额之间的关系
     * Propagation：事务的传播属性：默认是Propagation.REQUIRED
     * Propagation.REQUIRED: 事务中有多层嵌套，一个大事务包含多个小事务，必须一个大事务完整的完成，整个事务才成功，有其中的一个事务失败，
     * 整个大事务就失败！
     * Propagation.REQUIRES_NEW:事务中有多层嵌套，一个大事务包含多个小事务，每个小事务自己完成之后，就算是成功了，大事务要所有的小事务
     * 成功，才算成功，否则大事务就失败！
     * timeout:事务的超时时间，如果时间超过这个3000ms, 那么事务就自动失败！
     *
     * @param id           账户id
     * @param countCashier 总的金额
     * @return 返回执行结果
     */
    @Transactional(propagation = Propagation.REQUIRED, timeout = 3000)
    public int payForBookById(int id, double countCashier) throws Exception {
        int result = accountDao.payForBookById(id, countCashier);
        return result;
    }
}