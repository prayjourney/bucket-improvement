package com.zgy.learn.commontest;

/**
 * @Author: renjiaxin
 * @Despcription: 枚举类的定义和使用，枚举类和普通的类，最大的区别就是，他在定义的时候，就定义好了其中包含的数据
 *                而这些数据的定义，是按照它提供的构造函数来定义的，可以有多个字段，可以使用getset方法，和普通类一样。
 * @Date: Created in 2020/2/25 3:29
 * @Modified by:
 */
// 无参数的枚举
enum MyEnum01 {
    BLUE, RED, GREEN;
}

// 有参数的枚举
enum MyColor {
    BLUE("蓝色妖姬"), RED("烈焰红唇"), YELLOW("黄不可耐");
    String name;

    MyColor(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 有参数的枚举
enum Dog {
    ZH("中华田园犬",998), JP("日本柴犬",720), EN("英国哈士奇"),DE("德国牧羊犬",1433),
    JP2("日本秋田犬");
    // 属性: 品种
    String kind;
    // 属性: 价格
    Integer val;

    Dog(String kind) {
        this.kind = kind;
    }

    Dog(String kind, Integer val) {
        this.kind = kind;
        this.val = val;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "kind='" + kind + '\'' +
                ", val=" + val +
                '}';
    }
}
public class EnumTest {
    public static void main(String[] args) {
        System.out.println("我最喜欢的颜色：" + MyColor.RED.name);
        System.out.println("test: " + MyEnum01.BLUE);

        // Dog.valueOf("中华田园犬"); // 错误
        System.out.println(Dog.valueOf("ZH"));
        System.out.println(Dog.JP.getKind()+ "的价格是: "  + Dog.JP.getVal());
    }

}

