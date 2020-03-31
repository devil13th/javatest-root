package com.thd.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        Test.test01();
        Test.test02();
    }

    public static void test01()  throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        User u = new User();
        u.setName("devil13th");
        u.setBirthday(new Date());

        String json = mapper.writeValueAsString(u);
        System.out.println(json);

    }
    public static void test02() throws Exception{
        String json = "{\"name\":\"devil13th\",\"birthday\":1585669227270}";
        ObjectMapper mapper = new ObjectMapper();
        User u = mapper.readValue(json,User.class);
        System.out.println(u);
    }
}
