package com.thd.spring.annotation.ioc.lifecycle.test03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration 告诉spring这是一个配置类相当于传统xml配置文件
@Configuration
@ComponentScan
public class MainConfig {
}
