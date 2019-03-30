package com.thd.thread.api.t03threadsafety.t02;

public class Blogin implements Runnable {

	@Override
	public void run() {
		LoginServlet.login("b", "b_pwd");

	}

}
