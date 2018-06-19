package com.thd.jdbc;

import java.util.List;

import junit.framework.TestCase;

public class Test extends TestCase {
	private UserService us = new UserServiceImpl();
	
	public void testsave(){
		try{
			User u = new User();
			u.setPassword("xxa");
			u.setUsername("xxb");
			u.setRemark("ddc");
			us.save(u);
			System.out.println("save success return id:" + u.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testdelete(){
		try{
			us.delete(14);
			System.out.println("delete success");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testupdate(){
		try{
			User u= new User();
			u.setUsername("aaab");
			u.setPassword("bbbc");
			u.setRemark("cccd");
			u.setId(14);
			us.update(u);
			System.out.println("update success");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testloadUser(){
		try{
			int id = 1;
			User u= us.loadUser(id);
			if(u!=null){
			System.out.println("load user success");
			System.out.println("id:" + u.getId());
			System.out.println("username:" + u.getUsername());
			System.out.println("password:" + u.getPassword());
			System.out.println("remark:" + u.getRemark());
			}else{
				System.out.println("没有找到id是：" + id +" 的对象");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testquery(){
		try{
			List<User> l = us.query("x");
			if(l!=null || l.size()<=0){
				for(User u: l){
					System.out.println("========================");
					System.out.println("id:" + u.getId());
					System.out.println("username:" + u.getUsername());
					System.out.println("password:" + u.getPassword());
					System.out.println("remark:" + u.getRemark());
				}
			}else{
				System.out.println("空集合");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
