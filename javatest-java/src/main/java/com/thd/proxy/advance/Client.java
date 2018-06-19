package com.thd.proxy.advance;

import com.thd.proxy.UserManager;
import com.thd.proxy.UserManagerImpl;

public class Client {
	public static void main(String args[]){
		ProxyBean handler = new ProxyBean();
		//handler.invoke(new UserManagerImpl(), "addUsr", new Object[]{new UserManagerImpl()});
        UserManager um = (UserManager)handler.getProxy(new UserManagerImpl());
        String usr = um.addUsr("devil13th");//自动调用 SecurityHandler 的invoke方法  
        System.out.println(usr);
        System.out.println("===================");
        String r = um.deleteUsr("devil");
        System.out.println(r);
	}
}
