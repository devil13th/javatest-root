package com.thd.hibernate.concurrency.pessimistic;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void save(){
		SessionFactory sf = new Configuration().configure("com/thd/hibernate/concurrency/pessimistic/hibernate.cfg.xml").buildSessionFactory();
		Session session = null;
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Usrh u = new Usrh();
		u.setNickname("www");
		u.setPwd("123456");
		u.setUsr("oufen88");
		session.save(u);
		//tx.rollback();
		tx.commit();
		System.out.println("Success");
	}
	
	public static void update(){
		
		SessionFactory sf = new Configuration().configure("com/thd/hibernate/concurrency/pessimistic/hibernate.cfg.xml").buildSessionFactory();
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();
		Transaction tx2 = session2.beginTransaction();
		
		//使用悲观锁
		Usrh u1 = (Usrh)session1.load(Usrh.class, "8a808af13f7aa00a013f7aa00af40001",LockMode.UPGRADE);
		u1.setNickname("1113");
		u1.setPwd("123456" + Math.random());
		u1.setUsr("oufen88");
		session1.update(u1);
		
		//使用悲观锁
		Usrh u2 = (Usrh)session2.load(Usrh.class, "8a808af13f7aa00a013f7aa00af40001",LockMode.UPGRADE);
		u2.setNickname("2224" );
		u2.setPwd("123456"+ Math.random());
		u2.setUsr("oufen88");
		session2.update(u2);
		tx1.commit();
		tx2.commit();
		
		System.out.println("Success");
	}
	public static void main(String[] args) {
		//save();
		update();
	}
}
