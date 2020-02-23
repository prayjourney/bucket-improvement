package com.zgy.learn.factoryeasy;

import java.applet.AudioClip;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/2/23 20:39
 * @Modified by:
 */
public class Audi implements Car {
    @Override
    public void name() {
        System.out.println("I am audi!");
    }
}
