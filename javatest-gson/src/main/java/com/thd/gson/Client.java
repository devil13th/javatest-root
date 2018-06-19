package com.thd.gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Client {
	
	
	
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("张三");
		p.setAddr("中国");
		p.setAge(1);
		p.setBir(new Date());
		Card c = new Card();
		c.setCardNo("aa01");
		c.setPerson(p);
		
		GsonBuilder builder = new GsonBuilder();
		//yyyy-MM-dd HH:mm:ss
		//Gson gson = builder.setDateFormat("yyyy/MM/dd HH:mm:ss").create();
		Gson gson = builder.create();
		
		System.out.println("------------- Object 转 json --------------");
		String cardStr = gson.toJson(c);
		System.out.println(cardStr);
		
		//除字符串类型其他类型数据不能是空串
		String jsonStr = "{'cardNo':'bb01','person':{'name':'李四','age':'5','addr':'美国','bir':'2014-05-02 09:08:07','regist':'2001-01-01 01:01:01'}}";
		//String jsonStr = "{'cardNo':'bb01','person':{'name':'李四','age':2,'addr':'美国','bir':null}}";
		
		System.out.println("------------- json 转 Object --------------");
		Card cc = gson.fromJson(jsonStr, Card.class);
		System.out.println(cc.getCardNo());
		System.out.println(cc.getPerson().getName());
		System.out.println(cc.getPerson().getBir());
		System.out.println(cc.getPerson().getRegist());
		
		List<Card> l = new ArrayList();
		for(int i = 0 , j = 5 ; i < j ; i++){
			Card card = new Card();
			c.setCardNo("c_" + i );
			c.setPerson(new Person("p_"+ i ,i));
			l.add(c);
		}
		String newStr = gson.toJson(l);
		System.out.println(newStr);
		
		/*
		Map map = new HashMap();
		map.put("name", "zhangsan");
		map.put("age","5");
		map.put("sex","male");
		System.out.println(gson.toJson(map));*/
	
		System.out.println("-------------  json 转  List<Map> --------------");
		jsonStr = "[{'cardNo':'c_4','person':{'name':'p_4','age':4}},{'cardNo':'c_4','person':{'name':'p_4','age':4}},{'cardNo':'c_4','person':{'name':'p_4','age':4}},{'cardNo':'c_4','person':{'name':'p_4','age':4}},{'cardNo':'c_4','person':{'name':'p_4','age':4}}]";
		List<Map<String,String>> list = gson.fromJson(jsonStr, List.class);
		for(Map<String,String> obj : list){
			System.out.println(obj);
		}
		
		
		System.out.println("-------------  json 转  List<Object> --------------");
		// json转为带泛型的list  
		List<Card> list2 = gson.fromJson(jsonStr,new TypeToken<List<Card>>(){}.getType());
		for(Card obj : list2){
			System.out.println(obj.getCardNo() + "|" + obj.getPerson().getName() + "|" + obj.getPerson().getAge() );
		}
	}

}
