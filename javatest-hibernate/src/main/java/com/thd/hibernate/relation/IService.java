package com.thd.hibernate.relation;

import java.util.List;

public interface IService {
	
	
	
	
	/**
	 * 保存person对象 many to one
	 * @param person 
	 */
	public void savePerson(Person person);
	
	
	/**
	 * 查找room集合 many to one
	 * @return
	 */
	public List<Room> queryRoomList();
	
	/**
	 * 保存room对象
	 * @param room
	 */
	public void saveRoom(Room room);
	
	/**
	 * 查找person集合 many to one
	 * @return
	 */
	public List<Person> queryPersonList();
	
	/**
	 * 保存wife对象
	 * @param wife
	 */
	public void saveWife(Wife wife);
	
	/**
	 * 查找wife集合
	 */
	public List<Wife> queryWife();
	
	/**
	 * 保存hasband对象 one to one
	 * @param husBand
	 */
	public void saveHusband(Husband husBand);
	
	/**
	 * 查找husband集合
	 */
	public List<Husband> queryHusband();
	
	
	
	
	
	
}
