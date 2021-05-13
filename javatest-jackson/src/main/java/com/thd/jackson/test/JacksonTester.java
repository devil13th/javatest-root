package com.thd.jackson.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.thd.jackson.tools.*;
import com.thd.jackson.vo.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * com.thd.jackson.test.JacksonTester
 *
 * @author: wanglei62
 * @DATE: 2021/4/22 10:26
 **/

public class JacksonTester extends TestCase {

    /**
     * 基础用法 - 序列化
     */
    @Test
    public void testBasicSerialize() throws Exception{
        User u = new User();
        u.setUserAge(5);
        u.setUserBirthday(new Date());
        u.setUserId("1");
        u.setUserName("devil13th");
        u.setUserCreateTime(new Timestamp(new Date().getTime()));
        // 创建jackson工具
        ObjectMapper mapper = new ObjectMapper();
        // 序列化成字符串
        String json = mapper.writeValueAsString(u);
        System.out.println(json);

        // 序列化成比特数组
        byte[] bts = mapper.writeValueAsBytes(u);
        System.out.println(new String(bts));
    }

    /**
     * 基础用法 - 反序列化
     */
    @Test
    public void testBasicDeserialize() throws Exception{
        String str = "{\"userId\":\"1\",\"userName\":\"devil13th\",\"userAge\":5,\"userBirthday\":1619059279082,\"userCreateTime\":1619059279082}";
        // 创建jackson工具
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(str,User.class);
        System.out.println(user);
    }


    /**
     * 使用注释设置序列化/反序列化特性, 参见User01.java
     */
    @Test
    public void testSerializeSettingByAnnotation() throws Exception{
        User01 u = new User01();
        u.setUserAge(5);
        u.setUserBirthday(new Date());
        u.setUserId("1");

        u.setUserCreateTime(new Timestamp(new Date().getTime()));
        // 创建jackson工具
        ObjectMapper mapper = new ObjectMapper();
        // 序列化成字符串
        String json = mapper.writeValueAsString(u);
        System.out.println(json);

        // 序列化成比特数组
        byte[] bts = mapper.writeValueAsBytes(u);
        System.out.println(new String(bts));
    }


    /**
     * 序列化/反序列化设置 - 全局设置
     */
    @Test
    public void testDeserializeSetting() throws Exception{

        // 创建jackson工具
        ObjectMapper mapper = new ObjectMapper();
        // 设置在反序列化时忽略在JSON字符串中存在，而在Java中不存在的属性
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // pro属性不是User的属性
        String jsonStr = "{\"pro\":\"1\",\"userId\":\"1\",\"userName\":\"devil13th\",\"userAge\":5,\"userBirthday\":1619072177094,\"userCreateTime\":1619072177094}";
        User user = mapper.readValue(jsonStr,User.class);
        System.out.println(user);
    }


    /**
     * 自定义某类型全局的序列化和反序列化器
     */
    @Test
    public void testSerializer() throws Exception{
        User02 u = new User02();

        u.setUserId("1");
        u.setUserName("devil13th");

        Item item = new Item();
        item.setId(30);
        item.setName("mama");
        item.setType("family");
        u.setItem(item);

        // 创建jackson工具
        ObjectMapper mapper = new ObjectMapper();

        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

        // 创建某种自定义类型转换的模块
        SimpleModule itemModule = new SimpleModule();
        //设置Item对象的 序列化器和反序列化器
        itemModule.addSerializer(Item.class,new ItemSerializer());
        itemModule.addDeserializer(Item.class,new ItemDeserializer());
        // 注册模块到objectMapper中
        mapper.registerModule(itemModule);

        // 序列化成字符串
        String json = mapper.writeValueAsString(u);
        System.out.println(json);

        String jsonStr = "{\"userId\":\"1\",\"userName\":\"devil13th\",\"item\":\"20\"}";
        User02 u02 = mapper.readValue(jsonStr,User02.class);
        System.out.println(u02);
    }

    /**
     * 自定义的序列化和反序列化器(注释方式)
     */
    @Test
    public void testSerializerAnnotation() throws Exception{
        User03 u = new User03();

        u.setUserId("1");
        u.setUserName("devil13th");

        Item item = new Item();
        item.setId(30);
        item.setName("mama");
        item.setType("family");
        u.setItem(item);

        // 创建jackson工具
        ObjectMapper mapper = new ObjectMapper();

        // 序列化成字符串
        String json = mapper.writeValueAsString(u);
        System.out.println(json);

        String jsonStr = "{\"userId\":\"1\",\"userName\":\"devil13th\",\"item\":\"20\"}";
        User03 u03 = mapper.readValue(jsonStr,User03.class);
        System.out.println(u03);
    }



    /**
     * 序列化泛型
     */
    @Test
    public void testSerializeGeneric() throws Exception{
        User04 u = new User04();
        u.setUserId("1");
        u.setUserName("devil13th");

        List<Item> l = new ArrayList<Item>();
        for(int i = 0 , j = 3 ; i < j ; i++){
            Item item = new Item(i,"name_" + i , "type" + i);
            l.add(item);
        }
        u.setItemList(l);

        // 创建jackson工具
        ObjectMapper mapper = new ObjectMapper();
        // 序列化成字符串
        String json = mapper.writeValueAsString(u);
        System.out.println(json);

    }


    /**
     * 反序列化泛型
     */
    @Test
    public void testDeserializeGeneric() throws Exception{
        String str = "{\"userId\":\"1\",\"userName\":\"devil13th\",\"itemList\":[{\"id\":0,\"name\":\"name_0\",\"type\":\"type0\"},{\"id\":1,\"name\":\"name_1\",\"type\":\"type1\"},{\"id\":2,\"name\":\"name_2\",\"type\":\"type2\"}]}";
        // 创建jackson工具
        ObjectMapper mapper = new ObjectMapper();

        User04 user = mapper.readValue(str,User04.class);


        System.out.println(user);
    }


}
