package com.thd.hibernate.base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





public class Client {
	
	
	public static void save(){
		SessionFactory sf = new Configuration().configure("com/thd/hibernate/base/hibernate.cfg.xml").buildSessionFactory();
		Session session = null;
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Test01 u = new Test01();
		u.setNickname("www111");
		u.setPwd("123456111");
		u.setUsr("张三1111");
		session.save(u);
		//tx.rollback();
		tx.commit();
		System.out.println("Success");
	}
	
	
	public static void saveMore(){
		SessionFactory sf = new Configuration().configure("com/thd/hibernate/base/hibernate.cfg.xml").buildSessionFactory();
		Session session = null;
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		for(int i = 0 , j = 10000 ; i < j ; i++){
			Test01 u = new Test01();
			u.setNickname("nn" + i);
			u.setPwd("pwd" + i);
			u.setUsr("u" + i);
			session.save(u);
		}
		
		
		//tx.rollback();
		tx.commit();
		System.out.println("Success");
	}
	
	public static void update(){
		
		SessionFactory sf = new Configuration().configure("com/thd/hibernate/base/hibernate.cfg.xml").buildSessionFactory();
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();
		Transaction tx2 = session2.beginTransaction();
		
		Test01 u1 = (Test01)session1.load(Test01.class, "2c9a40b356fd9eff0156fd9f00fb0000");
		u1.setNickname("111");
		u1.setPwd("123456");
		u1.setUsr("newUserName");
		session1.update(u1);
		
		
		tx1.commit();
		System.out.println("Success");
	}
	
	
	public static void query(){
		UsrService userService = new UsrServiceImpl();
		List<Test01> l = userService.queryAllUsr(0, 5);
		for(Test01 t : l){
			System.out.println(t.getUsr() + ":" + t.getPwd());
		}
		System.out.println("finish");
		
	}
	
	public static void findTest01ById(){
		UsrService userService = new UsrServiceImpl();
		Test01 t = userService.findTest01ById("8a808af13c8f8de9013c8f8dea680001");
		System.out.println(t.getUsr() + ":" + t.getPwd());
	}
	
	
	
	public static void main(String[] args) {
		save();
		//update();
		//saveMore();
		//query();
		//findTest01ById();
	}

}
