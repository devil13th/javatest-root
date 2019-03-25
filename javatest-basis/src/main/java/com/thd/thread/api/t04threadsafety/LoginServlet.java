package com.thd.thread.api.t04threadsafety;

public class LoginServlet {
	private static String userName;
	private static String password;
	
	public static void login(String usr,String pwd) {
		
		/**
		 * 加上synchronized(LoginServlet.class)和不加的区别
		 */
		synchronized(LoginServlet.class){
			userName = usr;
			//模拟并发 
			if("a".equals(usr)) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			password = pwd;
			System.out.println(Thread.currentThread().getName() + " |  userName:" + userName + "   password:" + password);
		}
	}
}
