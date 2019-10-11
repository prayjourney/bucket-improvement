package com.zgy.learn.injectdetails;

import java.util.Map;

/**
 * @Author: renjiaxin
 * @Despcription: 超级巨星们
 * @Date: Created in 2019/10/11 20:16
 * @Modified by:
 */
public class SuperSingers {
    /**
     * 年代
     */
    private String time;
    /**
     * 歌手和代表作的Map
     */
    private Map<Singer, Song> representative;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Map<Singer, Song> getRepresentative() {
        return representative;
    }

    public void setRepresentative(Map<Singer, Song> representative) {
        this.representative = representative;
    }

    public SuperSingers() {
    }

    public SuperSingers(String time, Map<Singer, Song> representative) {
        this.time = time;
        this.representative = representative;
    }

    @Override
    public String toString() {
        return "SuperSinger{" +
                "time='" + time + '\'' +
                ", representative=" + representative +
                '}';
    }
}
