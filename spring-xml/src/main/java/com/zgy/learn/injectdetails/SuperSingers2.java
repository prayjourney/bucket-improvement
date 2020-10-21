package com.zgy.learn.injectdetails;

import java.util.Map;

/**
 * @Author: renjiaxin
 * @Despcription: 超级巨星们
 * @Date: Created in 2019/10/11 20:16
 * @Modified by:
 */
public class SuperSingers2 {
    /**
     * 年代
     */
    private String time;
    /**
     * 歌手和代表作的Map
     */
    private Map<String, Song> representative;

    public SuperSingers2(String time, Map<String, Song> representative) {
        this.time = time;
        this.representative = representative;
    }

    @Override
    public String toString() {
        return "SuperSingers2{" +
                "time='" + time + '\'' +
                ", representative=" + representative +
                '}';
    }
}
