package com.thd.spring.annotation.ioc.configuration.imports.importselector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

//使用@Import导入具体的类,该类实现了ImportSelector接口,定义了需要导入的类名数组
@Import({MyImportSelector.class})
public class MainConfig {
	
}
