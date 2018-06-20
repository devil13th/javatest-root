package com.thd.springboot.edu.edu01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

  
@Controller  

//@EnableAutoConfiguration   这就是spring boot的核心功能，自动配置。就是根据当前引入的JAR包进行自动配置
@EnableAutoConfiguration  
public class SampleController {  
  
    @RequestMapping("/")  
    @ResponseBody  
    //url  http://127.0.0.1:8888/sbt/
    String home() {  
        return "Hello World!";  
    }  
  
    public static void main(String[] args) throws Exception {  
    	//运行spring应用程序
        SpringApplication.run(SampleController.class, args);  
    }  
}  

/**
SpringApplication.run：运行spring应用程序
@Controller相关注解：都是spring mvc就有的功能
@EnableAutoConfiguration：这就是spring boot的核心功能，自动配置。就是根据当前引入的JAR包进行自动配置，比如：
引入了jackson的jar包，那么就会自动配置json转换，所以这里可以使用@ResponseBody
引入了spring boot的web模块，就会自动配置web.xml等与web项目相关的内容，所以这些配置都不需要我们自己配了

运行方式
不需要部署到tomcat服务器，上面说了内置的tomcat服务器，直接通过main方法运行，访问http://localhost:8080/
*/