package com.thd.hibernate.relation;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ServiceImpl implements IService{
	
	
	private SessionFactory sf = new Configuration().configure("com/thd/hibernate/relation/hibernate.cfg.xml").buildSessionFactory();
	private Session session =sf.openSession();
	private Logger log  = Logger.getLogger(this.getClass());
	
	
	
	//many to one
	
	/**
	 * 保存person对象
	 * @param person
	 */
	public void savePerson(Person person){
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
	};
	
	/**
	 * 查找room集合
	 * @return
	 */
	public List<Room> queryRoomList(){
		String hql = "from Room";
		Query query = session.createQuery(hql);
		List l = query.list();
		return l;
	};
	
	/**
	 * 保存room对象
	 * @param room
	 */
	public void saveRoom(Room room){
		Transaction tx = session.beginTransaction();
		session.save(room);
		tx.commit();
	};
	
	/**
	 * 查找person集合
	 * @return
	 */
	public List<Person> queryPersonList(){
		String hql = "from Person";
		Query query = session.createQuery(hql);
		List l = query.list();
		return l;
	};
	
	/**
	 * 保存wife对象
	 * @param wife
	 */
	public void saveWife(Wife wife){
		Transaction tx = session.beginTransaction();
		session.save(wife);
		tx.commit();
	};
	
	/**
	 * 查找wife集合
	 */
	public List<Wife> queryWife(){
		String hql = "from Wife";
		Query query = session.createQuery(hql);
		return query.list();
	};
	
	/**
	 * 保存hasband对象 one to one
	 * @param husBand
	 */
	public void saveHusband(Husband husBand){
		Transaction tx = session.beginTransaction();
		session.save(husBand);
		tx.commit();
	};
	
	/**
	 * 查找husband集合
	 */
	public List<Husband> queryHusband(){
		String hql = "from Husband";
		Query query = session.createQuery(hql);
		return query.list();
	};
	
	
}
