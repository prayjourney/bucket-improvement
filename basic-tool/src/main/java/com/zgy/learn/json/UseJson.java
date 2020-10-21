package com.zgy.learn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: renjiaxin
 * @Description: 使用Jackson 使用fastjson
 * @Date: 2019-11-19 01:34
 * @Modified by:
 */
public class UseJson {

    public static void main(String[] args) {
        /**
         * FastJson， 使用JSON這個工具類，就行了，可以解決大部分的需求
         */
        useFastJson();

        /**
         * 简单使用Jackson, 其中的ObjectMapper是一个使用的关键.
         */
        useJackson();

    }

    public static void useJackson() {
        // https://www.cnblogs.com/weixia-blog/p/9665189.html
        // https://www.cnblogs.com/ooo0/p/10902202.html
        // https://blog.csdn.net/m0_37076574/article/details/81317403
        // https://blog.csdn.net/u011054333/article/details/80504154
        // https://www.baeldung.com/jackson-annotations
        // https://www.cnblogs.com/30go/p/8963290.html
        // https://www.cnblogs.com/mwl523/p/10730315.html
        // https://blog.csdn.net/blueheart20/article/details/52212221
        // https://www.yiibai.com/jackson/
        // https://www.yiibai.com/jackson/jackson_object_serialization.html
        // https://www.yiibai.com/jackson/jackson_data_binding.html
        System.out.println("***********************************************************************\n\n");
        String s = "{\"name\": \"瑪利亞\",\"origin\": \"帕勞\",\"age\": 2}";
        ObjectMapper mapper = new ObjectMapper();
        // jsonStr--->object
        Dophine dophine = null;
        try {
            dophine = mapper.readValue(s, Dophine.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dophine.toString());
        System.out.println(dophine.getName());
        System.out.println("***********************************************************************\n\n");


        // object-->jsonStr
        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(new Hobby("開玩笑"));
        hobbies.add(new Hobby("看電影"));
        hobbies.add(new Hobby("甘美"));
        Student st1 = new Student(1, "張三", new Date(100, 2, 1), hobbies);
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(st1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonStr);
        System.out.println("***********************************************************************\n\n");

    }

    /**
     * json字符串的定義，首先這是一個字符串，所以必須被""包裹起來， 如同"xxxxxxxx", xxxxxxxx便是其中的內容
     * json字符串之中， 有
     * 普通字符串："abc", 這種氣勢沒什麼好解釋的
     * 數組字符串："[]"， []是數組的標誌， []不需要使用反義字符，但是每個字符串需要， 所以要用\"xx\"把我們的字符串包裹起來，
     * 使用定義的例子如："[\"你好\",\"紅果\" ,\"香港\"]";
     * map字符串："{}"， 是map的標誌， {}不需要使用反義字符， 但是每個字符串需要， 所以要用\"xx\"把我們的字符串包裹起來，
     * 使用定義的例子如："{\"name\":\"張三\",\"age\":22,\"home\":\"臺北\",\"school\":\"國立台灣科技大學\"}";
     * map+數組字符串：需要使用[]和{}, 這個就要看誰誰去裝載誰，數組->map: [{},{},{}], map->數組: {key1:[], key2:[]},
     * 一個例子："[{\"name\":\"張三\",\"age\":22,\"home\":\"臺北\",\"school\":\"國立台灣科技大學\"}," +
     * "{\"name\":\"北極熊\",\"age\":18,\"food\":\"鱈魚\"},{\"name\":\"牽牛花\",\"產地\":\"中國南方\"}]";
     */
    public static void useFastJson() {
        /* 序列化和反序列化
         * https://www.cnblogs.com/ooo0/p/10902202.html
         * https://blog.csdn.net/qq_36688143/article/details/79791544
         * https://blog.csdn.net/yaomingyang/article/details/79863995
         * https://blog.csdn.net/yqprogram/article/details/82858189
         * https://www.w3cschool.cn/fastjson/fastjson-ex1.html
         * 序列化:  就是将内存中的对象转换为字节序列，方便持久化到磁盘或者网络传输
         * 反序列化: 就是将字节序列转换为内存中的对象, 可以是文件中的，也可以是网络传输过来的
         */
        // JSONString <---> Object
        // JSONString <---> Array
        // JSONString <---> Map
        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(new Hobby("吃飯"));
        hobbies.add(new Hobby("喝水"));
        hobbies.add(new Hobby("開車"));
        hobbies.add(new Hobby("放風箏"));

        List<Hobby> hobbies2 = new ArrayList<>();
        hobbies2.add(new Hobby("開玩笑"));
        hobbies2.add(new Hobby("看電影"));
        hobbies2.add(new Hobby("甘美"));

        List<Dophine> dophines1 = new ArrayList<>();
        dophines1.add(new Dophine("張海豚", "德雷克海峽", 5));
        dophines1.add(new Dophine("紅孩兒", "加州灣", 3));

        List<Dophine> dophines2 = new ArrayList<>();
        dophines1.add(new Dophine("TOM", "北京", 5));
        dophines1.add(new Dophine("JERRY", "紐約", 3));
        dophines1.add(new Dophine("河童子", "日本", 3));


        // JSONString <---> Object
        Student xiaoming = new Student(1, "小明", new Date(2001, 2, 1), hobbies);
        String jsonXiaoming = JSON.toJSONString(xiaoming);
        System.out.println("object---> string :" + jsonXiaoming);

        String jsonStr = "{\"id\": 22, \"name\":\"amy\", \"birthday\": \"2001-2-12\"," +
                " \"hobbies\":[{\"name\": \"化妝\"}]}";
        Student stu = JSON.parseObject(jsonStr, Student.class);
        System.out.println("string---> object :" + stu.toString());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");


        // String <---> Map
        Map<String, String> sMap = new HashMap<>();
        sMap.put("姓名", "關羽");
        sMap.put("字", "雲長");
        sMap.put("故鄉", "河北涿縣");
        sMap.put("大哥", "劉備玄德");
        sMap.put("小弟", "張飛益德");
        String s = JSON.toJSONString(sMap);
        System.out.println("json str轉成 map: " + s);

        String str4Map = "{\"name\":\"張三\",\"age\":22,\"home\":\"臺北\",\"school\":\"國立台灣科技大學\"}";
        Map<String, String> map = (Map<String, String>) JSON.parse(str4Map);
        System.out.println("string 轉成 map: " + map);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");


        // JSONString <---> Array
        String arrStr = "[\"你好\",\"紅果\" ,\"香港\"]";
        JSONArray arr = JSON.parseArray(arrStr);
        System.out.println("arr的長度: " + arr.size() + "獲取最後一個值: " + arr.get(2));

        List ls4Arr = new ArrayList();
        ls4Arr.add("中島美雪");
        ls4Arr.add("22");
        ls4Arr.add("蘇州園林");
        ls4Arr.add("義和團");
        JSONArray array = new JSONArray(ls4Arr);
        String arrayStr = JSON.toJSONString(array);
        System.out.println(arrayStr);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");


        // JSONObject <---> Map
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Hello");
        jsonObject.put("fuckcc-pp", "你媽逼的");
        Map<String, Object> mp = JSON.parseObject(jsonObject.toJSONString(),
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println("轉換後map的長度為: " + mp.size() + "第二個值是: " + mp.get("name"));


        JSONObject object = (JSONObject) JSON.toJSON(sMap);
        System.out.println("大哥: " + object.getString("大哥") + ", 小弟:" + object.getString("小弟"));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");


        // JSONString <---> Array + Map
        String jsonMap1 = "[{\"name\":\"張三\",\"age\":22,\"home\":\"臺北\",\"school\":\"國立台灣科技大學\"}]";
        String jsonMap2 = "[{\"name\":\"張三\",\"age\":22,\"home\":\"臺北\",\"school\":\"國立台灣科技大學\"}," +
                "{\"name\":\"北極熊\",\"age\":18,\"food\":\"鱈魚\"},{\"name\":\"牽牛花\",\"產地\":\"中國南方\"}]";
        JSONArray array1 = JSON.parseArray(jsonMap1);
        JSONArray array2 = JSON.parseArray(jsonMap2);
        System.out.println(array1);
        System.out.println(array2);

        List list = new ArrayList();
        list.add(dophines1);
        list.add(dophines1);
        JSONArray sss = new JSONArray(list);
        String sssStr = JSON.toJSONString(sss);
        System.out.println(sssStr);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");


    }


}

class Student {
    private int id;
    private String name;
    // 目前對於LocalDate的java8 time 支持不是很好
    // @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private List<Hobby> hobbies;

    public Student() {
    }

    public Student(int id, String name, Date birthday, List<Hobby> hobbies) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", hobbies=" + hobbies +
                '}';
    }
}


/**
 * 學生愛好
 */
class Hobby {
    private String name;

    public Hobby() {
    }

    public Hobby(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Hobby{" +
                "name='" + name + '\'' +
                '}';
    }
}


/**
 * 海豚的一些屬性
 */

class Dophine {
    //    @JsonProperty(defaultValue = "sdfa", access = JsonProperty.Access.READ_ONLY)
    private String name;
    private String origin;
    private Integer age;

    public Dophine() {
    }

    public Dophine(String name, String origin, Integer age) {
        this.name = name;
        this.origin = origin;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dophine{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", age=" + age +
                '}';
    }
}