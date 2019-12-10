package com.zgy.learn.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: renjiaxin
 * @Description: 使用jackson, 一種是對於對象使用, 一種是對於的轉換, 另一種是對於複雜的內容的解析
 * @Date: 2019-12-10 23:58
 * @Modified by:
 */
public class MyJackson {
    public static String MYSTRING4JSON =
            "{ " +
                    "\"eventId\": \"5514663274220ba27a606710b451e8686df5c70f40f9466625516\", " +
                    "\"eventName\": \"receiveCommand\"," +
                    "\"eventTime\": 1546418172220," +
                    "\"userAppId\": \"196e06cc0d8d4230b5fd5f09d7fc4ac3\"," +
                    "\"eventData\":" +
                    "{" +
                        "\"destDevList\": " +
                            "[" +
                                "\"095581FC6B5CBB7E4C4BCA135F888888\"," +
                                "\"095581FC6B5CBB7E4C4BCA135F888777\"" +
                            "]," +
                        "\"devSpecToken\": \"3a968043-e0be-4144-b808-18713b07e0e8\"," +
                        "\"cmdTime\": \"2018-10-25 13:51:53\"," +
                        "\"cmdName\": \"CMD_SWITCH\"," +
                        "\"cmdParas\": " +
                            "{" +
                                "\"robotIotId\": \"1231werwr\"," +
                                "\"stmId\": \"asdsadsa123131\"," +
                                "\"xLocation\": 22.5," +
                                "\"yLocation\": 33.9," +
                                "\"angle\": 27.79," +
                                "\"createWorkFlow\": \"yes\"," +
                                "\"uniqueNo\": \"ifouaiosfhkoiu\"" +
                            "}," +
                        "\"cmdMetaInfo\":" +
                            "{" +
                                "\"lightSwitch\": \"灯开关\"," +
                                "\"lightBrand\": \"長城燈泡\"" +
                            "}" +
                    "}" +
            "}";

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(MYSTRING4JSON);
        System.out.println("========");
        parse2Jackson();
        System.out.println("========");
        object2Json();
        System.out.println("[][][][][][]");
        new MyJackson().json2Object();
    }

    // 通过读取读树的方法, 获取JSON或者字符串的内容
    public static void parse2Jackson() throws IOException {
        // 操作數據的mapper
        ObjectMapper mapper = new ObjectMapper();
        // Jackson提供一个树节点被称为"JsonNode",ObjectMapper提供方法来读json作为树的JsonNode根节点
        JsonNode node = mapper.readTree(MYSTRING4JSON);
        System.out.println("JsonNode的Node Type"  + node.getNodeType());
        String eventData = node.get("eventData").toString();
        String destDevList = node.get("eventData").path("destDevList").textValue();
        String cmdName = node.get("eventData").path("cmdName").textValue();
        JsonNode node2 = node.get("eventData").path("cmdParas");
        String cmdParas = node2.textValue();
        String robotIotId  = String.valueOf(node2.path("robotIotId"));
        System.out.println("eventData:" + eventData);
        System.out.println("destDevList:" +destDevList);
        System.out.println("cmdName:" +cmdName);
        System.out.println("cmdParas:" +cmdParas);
        System.out.println("robotIotId:" +robotIotId);

    }

    // json和对象的转化, 序列化和反序列化
    @Data
    @ToString
    @AllArgsConstructor
    public class Fish{
        int age;
        String name;
        String[] homes;
        Date time;
        public Fish(){}
    }

    public static String object2Json() throws ParseException, JsonProcessingException {
        // 使用ObjectMapper来转化对象为Json
        ObjectMapper mapper = new ObjectMapper();
        // 为了使JSON视觉上的可读性，增加一行如下代码，注意，在生产中不需要这样，因为这样会增大Json的内容
        // 配置mapper忽略空属性
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "2019-04-12 03:44:23";
        String[] homes= {"芬兰", "日本", "挪威"};
        Fish flagFish = new MyJackson().new Fish(2,"金枪鱼",homes, sdf.parse(date));
        String sstr = mapper.writeValueAsString(flagFish);
        System.out.println(sstr);
        return sstr;

    }

    public Fish json2Object() throws ParseException, IOException {
        String strJson = object2Json();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Fish fish =mapper.readValue(strJson, Fish.class);
        System.out.println(fish.toString());
        return fish;

    }

    // 反序列化暂时有点问题
    public Fish json2Object2() throws ParseException, IOException {
        String strJson = object2Json();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JsonNode node = mapper.readTree(strJson);
        int age = node.get("age").asInt();
        String name = node.path("name").asText();
        JsonNode homesNode  =node.path("homes");
        String home[] = {};
        ArrayList<String> sTemp = new ArrayList<>();
        for (JsonNode no: node) {
            sTemp.add(no.textValue());
        }
        String dateTime = node.get("time").asText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date t = sdf.parse(dateTime);

        Fish fish = new Fish(age,name, home,t);

        System.out.println(fish.toString());
        return fish;

    }
}
