package com.zgy.learn.injectdetails;

/**
 * @Author: renjiaxin
 * @Despcription: 歌曲
 * @Date: Created in 2019/10/11 2:24
 * @Modified by:
 */
public class Song {
    /**
     * 歌曲名称
     */
    private String name;
    /**
     * 歌曲时长
     */
    private float time;

    /**
     * 作词者
     */
    private Poet poet;

    // 使用构造器来注入
    public Song(String name, float time, Poet poet) {
        this.name = name;
        this.time = time;
        this.poet = poet;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", poet=" + poet +
                '}';
    }
}
