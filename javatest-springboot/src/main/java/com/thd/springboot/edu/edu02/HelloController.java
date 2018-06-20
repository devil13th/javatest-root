package com.thd.springboot.edu.edu02;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thd.springboot.restfulws.test02.User;

//@Controller+@ResponseBody组合，相当于在每个方法都加上@ResponseBody。  
@RestController  
public class HelloController {  
  //直接指定Post请求，同样也有@GetMapping  
  @PostMapping("/url")
  
  
  
  //url : http://127.0.0.1:8888/sbt/url
  //@RequestBody是指请求来的参数是json请求体，以json格式来转换到uer  
  public String hello(@RequestBody User user){  
      return "hello world";  
  }  
}  