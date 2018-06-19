package com.thd.hibernate.relation;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

public class ServiceImplTest extends TestCase {
	
private Logger log  = Logger.getLogger(this.getClass());
	
	
	private IService service = new ServiceImpl();
	
	public void test(){
		System.out.println("Junit Test OK!");
	}
	
	
	
	//many to one test
	
	
	/**
	 * 用于初始化数据
	 */
	public void testsaveRoom(){
		Room room = new Room();
		room.setRoomName("班级"+Math.random());
		service.saveRoom(room);
		System.out.println("Save Room Success");
	}
	
	/**
	 * 保存person对象 多对一的多端
	 */
	public void testsavePerson(){
		log.debug("------ many to one save test ------");
		Person person = new Person();
		person.setPersonName("姓名"+Math.random());
		List<Room> roomList = service.queryRoomList();
		if(roomList.isEmpty()){
			testsaveRoom();
		}
		person.setRoomId(roomList.get(0));
		service.savePerson(person);
		System.out.println("Save Person Success");
	}
	
	//many to one查询
	public void testqueryPersonList(){
		log.debug("------ many to one query test ------");
		List<Person> personList = service.queryPersonList();
		if(personList.isEmpty()){
			testsavePerson();
		}
		for(int i = 0 , j = personList.size() ; i < j ; i++){
			Person person = personList.get(i);
			System.out.println(person.getPersonName() + ":" + person.getRoomId().getRoomName());
		}
	}
	
	//one to many查询
	public void queryRoomList(){
		List<Room> roomList = service.queryRoomList();
		for(int i = 0 , j = roomList.size() ; i < j ; i++){
			Room room = roomList.get(i);
			System.out.println("------" + room.getRoomName() + "-----");
			
			Set<Person> personList = room.getPersons();
			System.out.println("共"+personList.size()+"人");
			Person person;
			for(Iterator<Person> iter = personList.iterator();iter.hasNext();){
				person = iter.next();
				System.out.println(person.getPersonName());
			}
		}
	}
	
	//保存wife
	public void testsaveWife(){
		Husband husband = new Husband();
		husband.setHasbandName("西门庆");
		service.saveHusband(husband);
		
		Wife wife = new Wife();
		wife.setWifeName("潘金莲");
		wife.setHusbandId(husband);
		service.saveWife(wife);
		System.out.println("success");
	}
	
	public void testqueryWife(){
		List<Wife> l = service.queryWife();
		Wife wife = null;
		for(Iterator<Wife> iter = l.iterator();iter.hasNext();){
			wife = iter.next();
			System.out.println(wife.getWifeName());
		}
	}
	
	
	
	
	//保存husband
	public void testsaveHasband(){
		Wife wife = new Wife();
		wife.setWifeName("狗女");
		service.saveWife(wife);
		
		Husband husband = new Husband();
		husband.setHasbandName("狗男");
		husband.setWifeId(wife);
		service.saveHusband(husband);
		
		
		System.out.println("success");
	}
	
	
	
}
