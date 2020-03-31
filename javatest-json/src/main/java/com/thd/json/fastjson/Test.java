/** 
 * Class Description:########
 * Date : 2017年9月27日 上午11:36:33
 * Auth : ccse 
*/  

package com.thd.json.fastjson;


import com.alibaba.fastjson.JSON;

import java.sql.Timestamp;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		Test.testToJson();
		Test.testParseObject();
		Test.testListToJson();
		Test.testMapToJson();
		Test.testJsonToMap();
	}

	public static void testToJson(){
		Person person = new Person();
		person.setAge(5);
		person.setName("devil13th");
		person.setBirthday(new Date());
		person.setCreateTime(new Timestamp(new Date().getTime()));
		person.setNickName("十三妖");
		String json = JSON.toJSONString(person);
		System.out.println(json);
	}

	public static void testParseObject(){
		String json = "{\"name\":\"devil13th\",\"birthday\":\"2019-12-11\",\"createTime\":1576681508433,\"myAge\":5,\"nickName\":\"十三妖\"}";
		Person p = JSON.parseObject(json, Person.class);
		System.out.println(p.toString());
	}


	public static void testListToJson(){
		List<Person> l = new ArrayList<Person>();
		for(int i = 0 , j = 3 ; i < j ; i++){
			Person person = new Person();
			person.setAge(5);
			person.setName("devil13th");
			person.setBirthday(new Date());
			person.setCreateTime(new Timestamp(new Date().getTime()));
			person.setNickName("十三妖");
			l.add(person);
		}



		String json = JSON.toJSONString(l);
		System.out.println(json);
	}


	public static void testMapToJson(){


		Map m = new HashMap();
		m.put("name","devil13th");
		m.put("age",5);
		m.put("birthday",new Date());
		m.put("createTime",new Timestamp(new Date().getTime()));
		String json = JSON.toJSONString(m);
		System.out.println(json);
	}


	public static void testJsonToMap(){
		String json = "{\"birthday\":1576681977915,\"createTime\":1576681977915,\"name\":\"devil13th\",\"age\":5}";
		Map m = JSON.parseObject(json,Map.class);
		System.out.println(m);
	}

}
