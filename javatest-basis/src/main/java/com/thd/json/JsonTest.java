package com.thd.json;

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
}
