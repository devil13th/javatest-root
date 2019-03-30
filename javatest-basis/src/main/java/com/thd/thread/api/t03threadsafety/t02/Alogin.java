package com.thd.thread.api.t03threadsafety.t02;

public class Alogin implements Runnable {

	@Override
	public void run() {
		LoginServlet.login("a", "a_pwd");

	}

}
