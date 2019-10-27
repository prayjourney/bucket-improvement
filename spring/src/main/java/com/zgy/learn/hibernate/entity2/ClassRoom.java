package com.zgy.learn.hibernate.entity2;

import org.springframework.stereotype.Component;

/**
 * @Author: renjiaxin
 * @Despcription: 班级/教室
 * @Date: Created in 2019/10/27 14:49
 * @Modified by:
 */
@Component
public class ClassRoom {
    private int rid;
    private String roomName;
    // private List<Student> students;


    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "rid=" + rid +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}
