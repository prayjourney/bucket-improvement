package com.zgy.learn.hibernate.entity2;

import org.springframework.stereotype.Component;

/**
 * @Author: renjiaxin
 * @Despcription: 学生
 * @Date: Created in 2019/10/27 14:50
 * @Modified by:
 */
@Component
public class Student {
    private int sid;
    private String name;
    private String gender;
    private int roomId;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
