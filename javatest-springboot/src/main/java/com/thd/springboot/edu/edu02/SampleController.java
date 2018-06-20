package com.thd.springboot.edu.edu02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


  
@Controller  
public class SampleController { 
	//依赖注入  Config中的hello
    @Autowired  
    String hello;  
      
    @RequestMapping(value="/")  
    @ResponseBody  
    //url http://127.0.0.1:8888/sbt/
    String test(){  
      return hello;  
    }  
  
     
}  