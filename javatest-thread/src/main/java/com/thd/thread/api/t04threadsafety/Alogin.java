package com.thd.thread.api.t04threadsafety;

public class Alogin implements Runnable {

	@Override
	public void run() {
		LoginServlet.login("a", "a_pwd");

	}

}
