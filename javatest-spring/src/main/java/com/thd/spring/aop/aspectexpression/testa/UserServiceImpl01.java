package com.thd.spring.aop.aspectexpression.testa;

import com.thd.spring.aop.aspectexpression.User;

public class UserServiceImpl01 implements UserService01 {

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
