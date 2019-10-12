package com.zgy.learn.tx.annotation.pojo;

import org.springframework.stereotype.Component;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/10/13 1:07
 * @Modified by:
 */
@Component(value = "book")
public class Book {
    private int isbn;
    private String name;
    private double price;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
