package com.thd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	//passwordEncoder的定义参见SecurityConfig.java
	@Autowired
	private PasswordEncoder passwordEncoder;
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		System.out.println("登录用户名" + username);
		//根据用户名查询出用户信息   , 此处使用passwordEncoder进行加密   
		//用户登录验证过程：
		/**
		 * 获取用户登录时候输入的用户名和密码
		 * 根据此类中loadUserByUsername方法获取的用户信息
				注意:
				 loadUserByUsername方法返回的用户信息中的密码是已经对密码进行加密后的字符串,
				   一般情况下保存到数据库的是用户注册时候输入的密码经过加密后的字符串
				   这里是例子所以设置用户密码的时候使用passwordEncoder.encode方法进行加密,一般下面的密码是从数据库读取的值(注册时候加密后的密码字符串)
			
		 */
		User u = new User(username,passwordEncoder.encode("123456"),AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_DBA,ROLE_USER"));
		System.out.println("加密后的密码：" + passwordEncoder.encode("123456"));
		return u;
	}

}
