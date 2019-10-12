package com.zgy.learn.tx.annotation.dao;

import com.zgy.learn.tx.annotation.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: renjiaxin
 * @Despcription: AccountDao
 * @Date: Created in 2019/10/13 1:09
 * @Modified by:
 */
@Repository(value = "accountDao")
public class AccountDao {

    @Autowired
    private Account account;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 检查是否有这个账户
     *
     * @param id id
     * @return false没有此id, true有此账户
     */
    public boolean checkID(int id) {
        String sql = "select id from account where id =?";
        RowMapper<Integer> rw = new SingleColumnRowMapper<>(Integer.class);
        int result = jdbcTemplate.queryForObject(sql, rw, id);
        if (result <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 通过id获取余额
     *
     * @param id id
     * @return 余额
     */
    public double getBalance(int id) {
        String sql = "select balance from account where id =?";
        RowMapper<Double> rw = new SingleColumnRowMapper<>(Double.class);
        return jdbcTemplate.queryForObject(sql, rw, id);
    }

    /**
     * 更新余额
     *
     * @param id
     * @param nu
     */
    public void updateBalance(int id, double nu) {
        String sql = "update account set balance = ? where id =?";
        jdbcTemplate.update(sql, nu, id);
    }
}
