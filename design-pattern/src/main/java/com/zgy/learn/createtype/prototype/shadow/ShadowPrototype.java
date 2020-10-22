package com.zgy.learn.createtype.prototype.shadow;

/**
 * @Author: renjiaxin
 * @Despcription: 浅克隆，不clone引用的对象
 * @Date: Created in 2020/2/26 15:39
 * @Modified by:
 */
public class ShadowPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 使用Cloneable接口完成浅克隆
        SimpleClone sc = new SimpleClone();
        SimpleClone scClone = (SimpleClone) sc.clone();
        System.out.println("sc :" + sc + ", sc hashcode : " + sc.hashCode());
        System.out.println("scClone :" + scClone + ", scClone hashcode : " + scClone.hashCode());
        System.out.println("================");

        // 使用自定义MyPrototype接口完成浅克隆
        MyPrototype oc = new OwnPrototypeClone();
        MyPrototype ocClone = (OwnPrototypeClone) oc.cloneMethod();
        System.out.println("oc :" + oc + ", oc hashcode : " + oc.hashCode());
        System.out.println("ocClone :" + ocClone + ", ocClone hashcode : " + ocClone.hashCode());
    }
}

// 使用Cloneable接口完成克隆
class SimpleClone implements Cloneable {
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// 自定义的clone接口
interface MyPrototype {
    // clone方法
    Object cloneMethod();
}

class OwnPrototypeClone implements MyPrototype {
    @Override
    public Object cloneMethod() {
        // 最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        MyPrototype myPrototype = new OwnPrototypeClone();
        return myPrototype;
    }
}


