package com.thd.spring.annotation.ioc.configuration.imports.importconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

//使用@Import导入具体的类
@Import({Fruit.class,Animal.class,Person.class})
public class MainConfigA {
	
}
