package com.thd.spring.aop.aspectexpression;

public class UserServiceImpl implements UserService {

	public User saveUser(User user) {
		user.setUser("save " +user.getUser());
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
