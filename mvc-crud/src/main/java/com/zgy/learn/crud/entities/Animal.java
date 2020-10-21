package com.zgy.learn.crud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-22 02:14
 * @Modified by:
 */
@Data
@AllArgsConstructor
public class Animal {
    private int id;
    private String name;
    private LocalDate birthday;
    //private String birthday;
    private String country;

    public Animal(){}
}
