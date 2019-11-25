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


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Monkey {
    @NotNull(message = "用户id不能为空")
    private Integer id;
    @Length(min = 2, max = 6, message = "用户姓名长度为{min}~{max}个字符")
    private String name;
    private Integer gender;
    //@Past(message = "是將來的時間！")
    private LocalDate birthday;

    public Monkey() {
    }
}