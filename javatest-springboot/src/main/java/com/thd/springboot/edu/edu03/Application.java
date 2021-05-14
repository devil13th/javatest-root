package com.thd.springboot.edu.edu03;

import com.thd.springboot.edu.edu02.Run;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication是spring boot最重要的一个注解，用于快捷配置启动类。
@SpringBootApplication  
public class Application {
    public static void main(String[] args) throws Exception {  
        SpringApplication.run(Application.class, args);
    }  
}  
/*
这个Run.java是一个独立的spring boot启动类，
这里不应该有业务功能，
上一篇的hello world业务代码应该写在一个单独的@Controller里面，
和上一篇相比，这里用@SpringBootApplication替换了@EnableAutoConfiguration。
*/