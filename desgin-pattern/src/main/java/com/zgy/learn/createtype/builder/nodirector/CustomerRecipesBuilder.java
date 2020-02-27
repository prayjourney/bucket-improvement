package com.zgy.learn.createtype.builder.nodirector;

/**
 * @Author: renjiaxin
 * @Despcription: 顾客来点餐，就生成了自己的食谱，具体的KFC点餐建造者， 此处消除了构造的顺序
 * @Date: Created in 2020/2/24 1:44
 * @Modified by:
 */
public class CustomerRecipesBuilder extends KFCBuilder {
    // 这是自己的菜单
    private  KFCRecipes recipes;

    // 具体的建造者来建造
    public CustomerRecipesBuilder() {
        recipes = new KFCRecipes();
    }

    @Override
    KFCBuilder buildA(String str) {
        recipes.setRecipe1(str);
        return this;
    }

    @Override
    KFCBuilder buildB(String str) {
        recipes.setRecipe2(str);
        return this;
    }

    @Override
    KFCBuilder buildC(String str) {
        recipes.setRecipe3(str);
        return this;
    }

    @Override
    KFCRecipes getRecipes() {
        return recipes;
    }
}
