package com.thd.spring.ioc.annotation.exam02;

import org.springframework.stereotype.Component;

//此注释相当于在xml中配置<bean id="usrDao" class="....."/>
@Component("usrDao")
public class UsrDao {
	public void save(){
		System.out.println("save usr");
	};
}
