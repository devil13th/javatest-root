[toc]
# ʹ������tomcat����spring boot��Ŀ


## ��Ŀ�ļ�Ŀ¼�ṹ

![](readmeimgs/01.png)
## ����pom.xml

- ����pom.xml
- �̳�spring-boot-starter-parent
- ����spring-boot-starter-web
- <span style="color:red">**ȥ��spring-boot-starter-tomcat**</span>

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.12.RELEASE</version>
	</parent>


	<groupId>com-thd-javatest</groupId>
	<artifactId>javatest-springboot-war</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	
	
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!--����spring boot��Ƕtomcat�����÷�Χ ������ʱ�������� -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
	</dependencies>
	
	
</project>
```

ע�⣺
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-tomcat</artifactId>
	<scope>provided</scope>
</dependency>
```
������war��û��spring-boot-starter-tomcat��

## ����������

- ����������ServletInitializer
- <span style="color:red">**�̳�SpringBootServletInitializer **</span> 
- <span style="color:red">**��д `SpringApplicationBuilder configure(SpringApplicationBuilder builder)` ���� **</span>
- ���������� public static void main(String[] args)

```
package com.thd.springbootwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
@SpringBootApplication  //������  
@PropertySource(value={"classpath:config/application.properties"},encoding="utf-8") //�����ļ�λ��
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		
		System.out.println("-----------------");
		return builder.sources(this.getClass());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServletInitializer.class, args);
	}

}
```

## ���������ļ�

```
# ����spring boot debugģʽ
debug=true



#����˿ں�(ʹ��springboot������������ʱ��������)
server.port=8888
#��Ŀ¼(ʹ��springboot������������ʱ��������)
server.servlet.context-path=/sbt


# mvc jspǰ׺
spring.mvc.view.prefix=/WEB-INF/
# mvc jsp��׺
spring.mvc.view.suffix=.jsp

```

## ����Spring MVC�����Դ

### ����Controller

```
package com.thd.springbootwar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Hello")
public class HelloController {
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView hello(String name){
		System.out.println(name);
		Map m = new HashMap();
		m.put("name", name);
		return new ModelAndView("index",m);
	}
}

```

### ����index.jsp

```
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>1234</title>
<link rel='stylesheet'  href="<%=request.getContextPath() %>/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>

<script type="text/javascript" src="<%=request.getContextPath() %>/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/webjars/jquery/2.2.4/jquery.min.js"></script>

<script>
</script>
</head>
<body>
<div id="a">hello : ${name}</div>
</body>
</html>
```

## ����web.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:web="http://java.sun.com/xml/ns/javaee" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>thdbaseframe</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```

## ���ʵ�ַ

`http://127.0.0.1:8000/javatest-springboot-war/Hello/hello?name=devil13th`
ע�⣺��ַ�еĶ˿ں�`8000`����Ŀ��Ŀ¼`javatest-springboot-war`��tomcat����server.xml�ļ������õ�����,��������Ŀ��application.properties�����õ�`server.port` �� `server.servlet.context-path`

## �ܽ�

������tomcat������Ŀ������tomcat��������

- ��������Ҫ�̳� SpringBootServletInitializer ����д�� `configure()` ����
- ȥ��spring-boot-starter-tomcat���� 









