package com.zgy.learn.feature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 到底该不该调用父类的构造方法呢？默认是调用无参构造方法，如果显示调用了有参构造方法，
 * 那就不会去调用无参构造方法，但是，如果调用有参构造方法，下面的情况，子类的字段又没有初始化？
 * 这是怎么回事？ 要如何解决？ 必须子类显示的初始化自己的字段吗？
 */
public class ConstructorAndFiledInExtends {
    public static void main(String[] args) {
        Fish f = new Fish("带鱼", "南美洲");
        Fish f2 = new GoldFish("金鱼", "中国", "红色");
        GoldFish gf = new GoldFish("大鲤鱼", "中国", "黄色");
        FlagFish ff = new FlagFish("旗鱼", "挪威", "长嘴背旗");
        System.out.println(f.toString());
        System.out.println(f2.toString());
        System.out.println(f2.getName());
        System.out.println(gf.toString());
        System.out.println(gf.getName());
        System.out.println(ff.toString());
        TestExtends t = new TestExtends("sff", 12);
        System.out.println(t.toString());
        System.out.println("======");
        System.out.println(new Student("ada", 22, 21).toString());

    }
}

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Fish {
    private String name;
    private String origin;
}

@Getter
@Setter
@ToString
class GoldFish extends Fish {
    private String color;
    /*
    // 子类对于父类而言，他的字段是默认继承了的，但是在使用的时候，还是要给他定义上，
    // 这样调用父类的方法，更加方便，不然没有的话，就是空的值null
    GoldFish(String color){
        super("","");
        this.color = color;
    }
    */
    private String name;
    private String origin;

    GoldFish(String name, String origin, String color) {
        //super(name, origin);
        this.color = color;
        System.out.println("子类调用了父类的构造器！");

    }
}


@Getter
@Setter
@ToString
class FlagFish extends Fish {
    private String feature;
    private String name;
    private String origin;

    FlagFish(String name, String origin, String feature) {
        this.name = name;
        this.origin = origin;
        this.feature = feature;
    }
}
/*
    子类调用了父类的构造器！
    子类调用了父类的构造器！
    Fish(name=带鱼, origin=南美洲)
    GoldFish(color=红色, name=null, origin=null)
    null
    GoldFish(color=黄色, name=null, origin=null)
    null
    FlagFish(feature=长嘴背旗, name=旗鱼, origin=挪威)
 */

class Parent {
    private String name;

    public Parent(String name) {
        this.name = name;
        System.out.println("Parent class");
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                '}';
    }
}

class TestExtends extends Parent {
    private String name;
    private Integer age;

    public TestExtends(String name, Integer age) {
        super(name);
        // 看来下面这个加上， 才会起作用
        this.name = name;
        this.age = age;
        System.out.println("TestExtends class");
    }

    public void testMode() {
        System.out.print(100 % 3);
        System.out.print(",");
        System.out.println(100 % 3.5);
    }

    @Override
    public String toString() {

        return "TestExtends{" +
                super.toString() +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

class Person {
    private String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    private int id;

    public Student(String name, int age, int id) {
        super(name, age);//显示调用父类构造器
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "age=" + age +
                ", id=" + id +
                '}';
    }
}