package com.thd.spring.aop.configuration.example01;

public class UserManagerImpl implements UserManager{

	public User saveUser(User user) {
		for(int i = 0 ; i < 1000 ; i ++){
			System.out.println("save " + user);
		}
		user.setPwd("newUser");
		user.setUser("i'm a user");
		return user;
	}

	public void deleteUser(User user) {
		System.out.println("delete " + user);
	}
	
}
