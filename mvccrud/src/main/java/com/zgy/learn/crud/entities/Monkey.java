package com.zgy.learn.crud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-24 03:26
 * @Modified by:
 */


@Data
@AllArgsConstructor
public class Monkey {
    private Integer id;
    private String name;
    private Integer gender;
    private LocalDate birthday;

    public Monkey() {
    }
}