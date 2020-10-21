package com.zgy.learn.feature;

/**
 * 公共的字段都定义在父类之中，而在子类之中，只是去定义我们新增的字段，然后这样我们去调用构造函数，
 * 就会把公共的字段初始化，在我们新的构造函数之中，新的字段就会初始化，而整个我们的对象，就会很好的初始化，
 * 如果我们在子类之中定义了新的和父类名称相同的字段，那就起不到我们动态的初衷，因为新的字段并没有把父类的字段，
 * 给覆盖掉，所以我们得到的子类对象的name字段【在父类之中也有】，就是null的。
 */
public class ConstructorAndExtends {
    public static void main(String[] args) {
        People p1 = new People("张三",22);
        People p2 = new Chinese("李四",27,"中国");
        Chinese c1 = new Chinese("王五",25,"中国台湾");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(c1.toString());
    }

}

class People {
    private String name;
    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Chinese extends People {
    private String nation;

    public Chinese() {
    }

    public Chinese(String name, int age, String nation) {
        super(name, age);
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {

        return "Chinese{" +
                super.toString() +
                "nation='" +
                nation + '\'' +
                '}';
    }
}
