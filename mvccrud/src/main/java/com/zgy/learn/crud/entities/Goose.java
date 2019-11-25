package com.zgy.learn.crud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-26 01:25
 * @Modified by:
 */
@Data
@AllArgsConstructor
public class Goose {
    private Integer id;
    private String name;
    private String quality;

    public Goose() {
    }
}
