package com.thd.springboot.edu.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/properties")
public class Controller {
	
	 @Autowired  
	 private Environment env; 

	 @Value("${m.b}")
	 private String msg;  
	
	 @Autowired
	 private MyWebConfig myWebConfig;
	
	@RequestMapping("/test01")
	//url http://127.0.0.1:8888/sbt/properties/test01
	public String test01() {
		System.out.println("-------- test01 ----------");
		System.out.println("msg:" + msg);
		
		System.out.println("m.a:" + env.getProperty("m.a"));
		System.out.println("m.b:" + env.getProperty("m.b"));
		return msg;
	}
	
	
	@RequestMapping("/test02")
	//url http://127.0.0.1:8888/sbt/properties/test02
	public MyWebConfig test02() {
		System.out.println("-------- test02 ----------");
		System.out.println("myWebConfig.getName:" + myWebConfig.getName());
		System.out.println("myWebConfig.getAge:" + myWebConfig.getAge());
		return myWebConfig;
	}
}
