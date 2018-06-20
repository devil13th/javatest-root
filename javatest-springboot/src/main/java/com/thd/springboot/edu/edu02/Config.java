package com.thd.springboot.edu.edu02;

import org.springframework.boot.SpringBootConfiguration;  
import org.springframework.context.annotation.Bean; 

//@SpringBootConfiguration：说明这是一个配置文件类，它会被@ComponentScan扫描到
@SpringBootConfiguration 
public class Config {  
	/*
	 * @Bean：就是在spring配置文件中声明了一个bean，赋值为hello world，String方法类型就是bean的类型，hello方法名是bean的id
	 * 
	 * 如果按传统方式是用xml配置文件来声明bean为 <bean id="hello" class="String"></bean>  
	 */
	
    @Bean  
    public String hello(){  
        return "Hello World";
    }  
}  