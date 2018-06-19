package com.thd.thread.api.t04threadsafety;

public class Blogin implements Runnable {

	@Override
	public void run() {
		LoginServlet.login("b", "b_pwd");

	}

}
