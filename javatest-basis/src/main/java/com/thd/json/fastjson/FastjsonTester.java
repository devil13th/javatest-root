package com.thd.json.fastjson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastjsonTester extends TestCase {
	@Test
	/**
	 * 对象或Map转json
	 */
	public void testObjectOrMapToJSON(){
		
		
		
		Person p = new Person();
		p.setName("张三");
		p.setSex(2);
		p.setBirthday(new Date());
		p.setChilds(null);
		p.setFather(null);
		String jsonString = JSON.toJSONString(p);
		System.out.println(jsonString);
		
		
	
		
	}
	
	@Test
	/**
	 * json转对象或Map
	 */
	public void testJSONToObjectOrMap(){
		String jsonString = "{\"birthday\":1556603909275,\"name\":\"张三\",\"sex\":2}";
		Person p = JSON.parseObject(jsonString, Person.class);
		System.out.println(p);
		
		Map m = JSON.parseObject(jsonString, Map.class);
		System.out.println(m);
		
		
	}
	
	
	@Test
	/**
	 * 使用JSONObject创建JSONObject对象后转json
	 */
	public void testCreateJsonObject(){
		JSONObject parent = new JSONObject();
		parent.put("name", "张三");
		parent.put("age", 5);
		parent.put("birthday", new Date());
		List l = new ArrayList();
		for(int i = 0 , j = 5 ; i < j ; i++){
			JSONObject child = new JSONObject();
			child.put("name", "child-" + i);
			child.put("age", i);
			child.put("birthday", new Date());
			l.add(child);
		}
		parent.put("childs", l);
		String str = parent.toString();
		
		
		System.out.println(str);
		System.out.println(parent.toJSONString());
		
		
	}
	
	
	@Test
	/**
	 * 使用JSONArray创建JSONArray对象后转json
	 */
	public void testCreateJsonArray(){
		JSONArray list = new JSONArray();
		for(int i = 0 , j = 5 ; i < j ; i++){
			JSONObject child = new JSONObject();
			child.put("name", "child-" + i);
			child.put("age", i);
			child.put("birthday", new Date());
			list.add(child);
		}
		String str = list.toString();
		System.out.println(str);
		
		
	}
	
	
	@Test
	/**
	 * 设置json转换时的日期格式
	 */
	public void testJsonDateFormater(){
		
		Map m = new HashMap();
		m.put("name", "devil13th");
		m.put("age", 5);
		m.put("birthday", new Date());
		m.put("nullprop", null);
		
		//转JSON的时候指定日期格式  
		//SerializerFeature.WriteDateUseDateFormat 是使用JSON.DEFFAULT_DATE_FORMAT指定的日期格式
		//SerializerFeature.WriteMapNullValue 如果属性值是null也会序列化
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		String json = JSON.toJSONString(m,SerializerFeature.WriteDateUseDateFormat,SerializerFeature.WriteMapNullValue);
		System.out.println(json);
		
		//内置的日期格式会自动匹配,yyyy-MM-dd 或  时间戳 可以自动转换
		Person mto = JSON.parseObject(json, Person.class);
		System.out.println(mto);
		
		
		//转JSON的时候指定自定义的日期格式
		String json2 = JSON.toJSONStringWithDateFormat(m, "MM-dd YY", SerializerFeature.WriteDateUseDateFormat);
		System.out.println(json2);
		
		//将自定义的日期格式转换为对象
		
		
	
	}
	
	
}
