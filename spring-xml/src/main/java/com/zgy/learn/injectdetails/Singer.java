package com.zgy.learn.injectdetails;

import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription: 歌手
 * @Date: Created in 2019/10/11 2:27
 * @Modified by:
 */
public class Singer {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 歌唱作品
     */
    private List<Song> songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Singer() {
    }

    public Singer(String name, int age, List<Song> songs) {
        this.name = name;
        this.age = age;
        this.songs = songs;
    }

    /**
     * 打印歌手所有的歌曲
     */
    public void getAllSongs() {
        StringBuilder songsInfo = new StringBuilder();
        for (Song s : songs) {
            songsInfo.append(s.getName() + ", ");
        }
        String info = songsInfo.toString().substring(0, songsInfo.length() - 2);
        String sss = String.format("%s的音乐作品有: %s", this.getName(), info);
        System.out.println(sss);
    }

}
