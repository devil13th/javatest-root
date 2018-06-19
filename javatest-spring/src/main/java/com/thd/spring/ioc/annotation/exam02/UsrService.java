package com.thd.spring.ioc.annotation.exam02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//此注释相当于在xml中配置<bean id="usrService" class="....."/> 注意：这个id是类名，第一个字母小写！
@Component
public class UsrService {
	@Autowired
	@Qualifier("usrDao")
	private UsrDao dao;
	public void save(){
		dao.save();
	}
}
