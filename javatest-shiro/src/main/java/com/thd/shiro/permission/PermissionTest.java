package com.thd.shiro.permission;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;



public class PermissionTest extends TestCase{
	private Subject subject;
	@Test
	public void test01(){
		System.out.println("-------- test01 -----------");
		login("classpath:com/thd/shiro/permission/shiro-role.ini","zhang","123");
		System.out.println("登录人："+subject.getPrincipal().toString());
		System.out.println("具有role1?" + subject.hasRole("role1")); 
		System.out.println("具有role2?" + subject.hasRole("role2")); 
		System.out.println("具有role3?" + subject.hasRole("role3")); 
		
		
		List l = new ArrayList();
		l.add("role1");
		l.add("role2");
		//判断拥有角色：role1 and role2 
		System.out.println("具有role1和role2?" + subject.hasAllRoles(l)); 
		l.add("role3");
		//判断拥有角色：role1 and role2 and role3
		System.out.println("具有role1和role2和role3?" + subject.hasAllRoles(l)); 

		
	}
	
	
	@Test 
	 public void testIsPermitted() { 
		 login("classpath:com/thd/shiro/permission/shiro-role-permission.ini", "zhang", "123"); 
		 //判断拥有权限：user:create 
		 System.out.println("判断拥有权限：user:create --- :" + subject.isPermitted("user:create")); 
		 //判断拥有权限：user:update and user:delete 
		 System.out.println("判断拥有权限：user:update and user:delete --- :" + subject.isPermittedAll(new String[]{"user:update","user:delete"}));

		 //判断没有权限：user:view 
		 System.out.println("判断没有权限：user:view --- :" + subject.isPermitted("user:view")); 
	 }
	
	public void login(String iniPath,String usr,String pwd){
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory =
		new IniSecurityManagerFactory(iniPath);
		//2、得到SecurityManager实例并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(usr, pwd);
		try {
		//4、登录，即身份验证
			subject.login(token);
		} catch (AuthenticationException e) {
		//5、身份验证失败
			System.out.println("登录失败");
		}
		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
		System.out.println("用户是否已经登录:" + subject.isAuthenticated());
		
	}
}
