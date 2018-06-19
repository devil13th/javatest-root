package com.thd.hibernate.concurrency.optimistic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void save(){
		SessionFactory sf = new Configuration().configure("com/thd/hibernate/concurrency/optimistic/hibernate.cfg.xml").buildSessionFactory();
		Session session = null;
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Usrh u = new Usrh();
		u.setNickname("www");
		u.setPwd("123456");
		u.setUsr("zhangsan");
		session.save(u);
		//tx.rollback();
		tx.commit();
		System.out.println("Success");
	}
	
	public static void update(){
		
		/*
		 * 乐观锁说明：
		 * 事务tx1 和 tx2同时修改Usr对象，当tx2提交后版本v属性已经加1 ， 当tx1提交的时候 发现版本v已经改变，所以tx1提交的时候抛出了异常
		 */
		
		
		SessionFactory sf = new Configuration().configure("com/thd/hibernate/concurrency/optimistic/hibernate.cfg.xml").buildSessionFactory();
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();
		Transaction tx2 = session2.beginTransaction();
		
		Usrh u1 = (Usrh)session1.load(Usrh.class, "8a808af13f7aa00a013f7aa00af40001");
		u1.setNickname("1113");
		u1.setPwd("123456" + Math.random());
		u1.setUsr("zhangsan");
		session1.update(u1);
		
		
		Usrh u2 = (Usrh)session2.load(Usrh.class, "8a808af13f7aa00a013f7aa00af40001");
		u2.setNickname("2224" );
		u2.setPwd("123456"+ Math.random());
		u2.setUsr("zhangsan");
		session2.update(u2);
		
		tx2.commit();
		tx1.commit();
		System.out.println("Success");
	}
	public static void main(String[] args) {
		//save();
		update();
	}
}
