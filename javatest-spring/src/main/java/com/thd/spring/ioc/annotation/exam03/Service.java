package com.thd.spring.ioc.annotation.exam03;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {
	@Resource
	private UsrDao usrDao;
	@Resource
	private RoleDao roleDao;
	@Resource
	private FunDao funDao;
	
	
	
	public void saveUsr(){
		this.usrDao.save();
	}
	
	public void saveRole(){
		this.roleDao.save();
	}
	
	public void saveFun(){
		this.funDao.save();
	}
}
