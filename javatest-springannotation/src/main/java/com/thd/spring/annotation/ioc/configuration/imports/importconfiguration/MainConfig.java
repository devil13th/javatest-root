package com.thd.spring.annotation.ioc.configuration.imports.importconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

//使用@Import导入一个配置类
@Import(MainConfigA.class)
public class MainConfig {
	
}
