package com.zgy.learn.createtype.builder.nodirector;

/**
 * @Author: renjiaxin
 * @Despcription: KFC菜谱，这个具体的产品
 * @Date: Created in 2020/2/24 1:34
 * @Modified by:
 */
public class KFCRecipes {
    // 默认菜谱
    private String recipe1= "可乐";
    private String recipe2 = "汉堡";
    private String recipe3 = "鸡块";

    public void setRecipe1(String recipe1) {
        this.recipe1 = recipe1;
    }

    public void setRecipe2(String recipe2) {
        this.recipe2 = recipe2;
    }

    public void setRecipe3(String recipe3) {
        this.recipe3 = recipe3;
    }

    @Override
    public String toString() {
        return "KFCRecipes{" +
                "recipe1='" + recipe1 + '\'' +
                ", recipe2='" + recipe2 + '\'' +
                ", recipe3='" + recipe3 + '\'' +
                '}';
    }
}
