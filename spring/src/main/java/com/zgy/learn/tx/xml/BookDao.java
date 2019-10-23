package com.zgy.learn.tx.xml;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/13 1:09
 * @Modified by:
 */
public class BookDao {
    JdbcTemplate jdbcTemplate;

    Book book;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 检查仓库之中是否有此书
     *
     * @return false无此书，true有此书
     */
    public boolean checkIsbn(int isbn) {
        String sql = "select count(isbn) from book where isbn = ?";
        RowMapper<Integer> rm = new SingleColumnRowMapper<>(Integer.class);
        int result = jdbcTemplate.queryForObject(sql, rm, isbn);
        if (result <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 通过isbn获取书籍的库存量
     *
     * @param isbn isbn
     * @return 书籍库存
     */
    public int queryBookStockByIsbn(int isbn) {
        String sql = "select stock from book where isbn =?";
        RowMapper<Integer> rm = new SingleColumnRowMapper<>(Integer.class);
        return jdbcTemplate.queryForObject(sql, rm, isbn);
    }

    /**
     * 通过isbn来获取书籍价格
     *
     * @param isbn
     * @return 价格
     */
    public double queryBookPriceByIsbn(int isbn) {
        String sql = "select price from book where isbn = ?";
        RowMapper<Double> rm = new SingleColumnRowMapper<>(Double.class);
        return jdbcTemplate.queryForObject(sql, rm, isbn);
    }

    /**
     * 更新库存
     *
     * @param isbn  isbn
     * @param stock 库存
     */
    public void updateStockByIsbn(int isbn, int stock) {
        String sql = "update book set stock =? where isbn =?";
        jdbcTemplate.update(sql, stock, isbn);

    }

    /**
     * 买书，此处要关心的是书的库存和我们要购买的数量之间的关系， 如果不够，那就执行不成功，这看成是一个事务
     *
     * @param isbn   isbn
     * @param number number
     * @return 返回总价
     */
    public double buyTheBookByIsbn(int isbn, int number) throws Exception {
        // 查询库存
        String queryStock = "select stock from book where isbn = ?";
        RowMapper<Integer> rm = new SingleColumnRowMapper<>(Integer.class);
        int stock = jdbcTemplate.queryForObject(queryStock, rm, isbn);
        if (stock - number < 0) throw new Exception("库存不够！");

        // 更新库存
        String updateStock = "update book set stock =? where isbn =?";
        jdbcTemplate.update(updateStock, stock - number, isbn);

        // 查询单价
        String getPrice = "select price from book where isbn =?";
        double price = jdbcTemplate.queryForObject(getPrice, rm, isbn);

        // 返回总价
        return price * number;
    }
}

