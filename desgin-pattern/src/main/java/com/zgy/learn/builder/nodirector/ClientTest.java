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
    }
}
