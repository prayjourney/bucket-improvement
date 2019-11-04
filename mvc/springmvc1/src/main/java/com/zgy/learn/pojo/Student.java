package com.zgy.learn.pojo;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-04 15:43
 * @Modified by:
 */
public class Student {
    String name;
    int id;
    Address address;

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
