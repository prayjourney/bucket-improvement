package com.zgy.learn.bootjpa.bootjpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: renjiaxin
 * @Despcription: 使用jpa来完成配置映射关系
 * @Date: Created in 2019/12/19 2:22
 * @Modified by:
 */
@Data
@Entity
@Table(name = "tb_user")
public class User {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 自增主键
    private Integer id;
    @Column(name = "last_name", length = 50) //列名
    private String lastName;
    @Column(name = "email")
    private String email;
}
