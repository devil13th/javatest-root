/** 
 * Class Description:########
 * Date : 2017年9月27日 上午11:36:33
 * Auth : ccse 
*/  

package com.thd.json;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class Test {

	public static void main(String[] args) {
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		 
		JsonPerson jp = new JsonPerson();
		jp.setAge(4);
		jp.setBir(new Date());
		jp.setName("张三");;
		JSONObject jObj = JSONObject.fromObject(jp,jsonConfig);
		System.out.println(jObj.toString());
		
		
		String jsonStr = "{'age':4,'bir':'2014-06-25','name':'张三'}";
		JSONObject jObj2 = JSONObject.fromObject(jsonStr);
		System.out.println(jObj2.get("bir"));
		
		JsonPerson jp2 = (JsonPerson)JSONObject.toBean(jObj2,JsonPerson.class);
		System.out.println(jp2.getBir());
	}

}
