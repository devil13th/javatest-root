package com.thd.spring.aop.configuration.example02;

public class UserServiceImpl implements UserService {

	public User saveUser(User user) {
		user.setUser("save " +user.getUser());
		for(int i = 0 , j = 10000 ; i < j ; i++){
			System.out.println(i);
		}
		return user;
	}

	public User updateUser(User user) throws Exception{
		user.setUser("update " +user.getUser());
		
		
		if("123456".equals(user.getPwd())){
			throw new Exception(" password is so simple !!!!");
		}
		return user;
	}

}
