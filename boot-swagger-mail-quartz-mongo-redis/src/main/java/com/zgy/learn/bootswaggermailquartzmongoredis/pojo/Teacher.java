package com.zgy.learn.bootswaggermailquartzmongoredis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int id;
    private String name;
    private String gender;
    // 教授的课程
    private String course;
    // 电话
    private String phone;
}
