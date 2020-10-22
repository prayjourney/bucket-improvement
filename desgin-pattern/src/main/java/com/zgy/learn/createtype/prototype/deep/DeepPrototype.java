package com.zgy.learn.createtype.prototype.deep;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author: renjiaxin
 * @Despcription: 深克隆，clone引用的对象
 * @Date: Created in 2020/2/26 15:39
 * @Modified by:
 */
public class DeepPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 浅克隆
        SimpleCloneTest sct = new SimpleCloneTest("张三", new Date());
        SimpleCloneTest scCloneTest = (SimpleCloneTest) sct.clone();
        System.out.println("sct :" + sct + ", sct hashcode : " + sct.hashCode());
        System.out.println("scCloneTest :" + scCloneTest + ", scCloneTest hashcode : " + scCloneTest.hashCode());
        System.out.println("================");

        // 深克隆
        DeepCloneTest dct = new DeepCloneTest("张三", new Date());
        DeepCloneTest dcCloneTest = (DeepCloneTest) dct.clone();
        System.out.println("dct :" + dct + ", dct hashcode : " + dct.hashCode());
        System.out.println("dcCloneTest :" + dcCloneTest + ", dcCloneTest hashcode : " + dcCloneTest.hashCode());
        System.out.println("================");
    }
}

@Data
@AllArgsConstructor
class SimpleCloneTest implements Cloneable {
    String name;
    Date date;

    // clone方法没有做任何动作，只能去浅克隆，不能处理对象引用的问题
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

@Data
@AllArgsConstructor
class DeepCloneTest implements Cloneable {
    String name;
    Date date;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCloneTest obj = (DeepCloneTest) super.clone();
        // 对这个对象的属性，做一些操作
        Date date = new Date(951556988); // 2000-02-26 17:23:08
        obj.setDate(date);
        return obj;
    }
}
