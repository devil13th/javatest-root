package com.thd.json.jsonlib;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.junit.Test;

public class JsonTest extends TestCase {
	@Test
	/**
	 * JSON字符串与Object相互转换
	 */
	public void test01(){
		Person p0 = new Person();
		p0.setBirthday(new Date());
		p0.setName("yeye");
		p0.setSex(1);
		
		Person p = new Person();
		p.setBirthday(new Date());
		p.setName("baba");
		p.setSex(1);
		p.setFather(p0);
		
		Person p1 = new Person();
		p1.setBirthday(new Date());
		p1.setName("erzi");
		p1.setSex(1);
		
		Person p2 = new Person();
		p2.setBirthday(new Date());
		p2.setName("nver");
		p2.setSex(2);
		
		List childs = new ArrayList();
		childs.add(p1);
		childs.add(p2);
		
		p.setChilds(childs);
		
		JsonConfig config = new JsonConfig();     
		//config.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));  
		config.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
		//config.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
         
		JSONObject jsonObj = JSONObject.fromObject(p,config);
		String jsonStr = jsonObj.toString();
		System.out.println(jsonStr);
		
		
		 JSONObject  jsonObject = JSONObject.fromObject (jsonStr);
		 System.out.println(jsonObject);
		 System.out.println(jsonObject.getString("name"));
		 System.out.println(jsonObject.getJSONObject("father").getString("name"));
		 System.out.println(jsonObject.getJSONObject("father").getString("birthday"));
		 
		 
         JSONArray jsonArray = JSONArray.fromObject("[{a:1},{a:2},{a:3}]") ;
         
	}
	
	
	
	@Test
	public void test02(){
		
		JsonConfig config = new JsonConfig();     
		//config.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));  
		config.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		
		
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
		
	}
}
