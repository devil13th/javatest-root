package com.thd.hibernate.base;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UsrServiceImpl implements UsrService {
	
	private SessionFactory sf = new Configuration().configure("com/thd/hibernate/base/hibernate.cfg.xml").buildSessionFactory();
	private Session session =sf.openSession();
	private Logger log  = Logger.getLogger(this.getClass());
	public void save(Test01 u){
		log.debug(" ============= begin =============== ");
		Transaction tx = session.beginTransaction();
		try{
			session.save(u);
			tx.commit();
			log.debug(" ============= save success =============== ");
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			log.debug(" ============= save failure =============== ");
		}finally{
			session.close();
			log.debug(" ============= end =============== ");
		}
	};
	
	
	
	public List queryUsrByNickName(String usrName){
		Transaction tx = session.beginTransaction();
		StringBuffer hql = new StringBuffer("from Test01 u where 1=1");
		
		if(usrName != null && !usrName.trim().equals("")){
			hql.append(" and u.nickname like ?");
		}
		Query query = session.createQuery(hql.toString());
		query.setParameter(0,"%" + usrName + "%");
		List l = query.list();
		session.close();
		
		
		return l;
	};
	
	public List<Test01> queryAllUsr(int begin,int count){
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Test01");
		query.setFirstResult(begin);
		query.setMaxResults(count);
		List<Test01> l =  (List<Test01>)query.list();
		/*for(Test01 u : l){
			u.setPwd("a");
		}
		
		
		
		for(Test01 u : l){
			System.out.println(u);
			u.setPwd("bb");
			session.update(u);
			session.delete(u);
		}
		
		*/
		tx.commit();
		System.out.println("session:" + session);
		//findTest01ById("8a808af13c8f8de9013c8f8dea680001");
		session.close();
		
		return l;
	};
	
	public Test01 findTest01ById(Serializable id){
		System.out.println("session:" + session);
		Test01 t = (Test01)session.get(Test01.class, id);
		t.setPwd("xy");
		session.update(t);
		session.close();
		return t;
	}
	
}
