package com.zgy.learn.builder.nodirector;

/**
 * @Author: renjiaxin
 * @Despcription: 测试
 * @Date: Created in 2020/2/24 1:49
 * @Modified by:
 */
public class ClientTest {
    public static void main(String[] args) {
        CustomerRecipesBuilder builder = new CustomerRecipesBuilder();
        KFCRecipes recipes = builder.getRecipes();
        System.out.println(recipes);
        // 上述是默认的操作， 因为返回的都是Builder， 而且无顺序，还可以链式操作
        CustomerRecipesBuilder builder2 = new CustomerRecipesBuilder();
        builder2.buildA("雪碧").buildB("老八秘制小汉堡").buildC("上校鸡块"); // 链式编程
        KFCRecipes recipes2 = builder2.getRecipes();
        System.out.println(recipes2);
    }
}
