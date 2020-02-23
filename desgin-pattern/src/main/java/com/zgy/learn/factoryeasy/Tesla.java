package com.zgy.learn.factoryeasy;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/23 20:41
 * @Modified by:
 */
public class Tesla  implements Car {
    @Override
    public void name() {
        System.out.println("I am tesla!");
    }
}
