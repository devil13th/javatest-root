package com.thd.spring.ioc.annotation.exam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Service {
	//注释在变量上 自动装配 在spring中取id为usrDao的bean 这种注释可以省略setter getter
	@Autowired
	private UsrDao usrDao;
	
	private RoleDao roleDao;
	
	//自动装配 只不过不是spring根据名称装配，而是指定spring中id为funsDao的bean 如果不这么配置则找的是funDao
	@Autowired
	@Qualifier("funsDao")
	private FunDao funDao;
	
	
	
	public RoleDao getRoleDao() {
		return roleDao;
	}
	//注释在setter上 自动装配  在spring中取id为roleDao的bean
	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	
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
