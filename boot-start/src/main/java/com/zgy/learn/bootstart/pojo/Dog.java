package com.zgy.learn.bootstart.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-12-03 02:01
 * @Modified by:
 */
@Data
@AllArgsConstructor
public class Dog {
    private String name;
    private Integer age;
}
