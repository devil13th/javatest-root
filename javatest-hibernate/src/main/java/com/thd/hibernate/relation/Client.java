package com.thd.hibernate.relation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	
	
	public static void main(String[] args) {
		IService service = new ServiceImpl();
		Husband husband = new Husband();
		husband.setHasbandName("西门庆");
		service.saveHusband(husband);
		
		Wife wife = new Wife();
		wife.setWifeName("潘金莲");
		wife.setHusbandId(husband);
		service.saveWife(wife);
		System.out.println("success");
	}

}
