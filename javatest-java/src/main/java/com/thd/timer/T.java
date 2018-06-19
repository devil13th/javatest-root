package com.thd.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer = new Timer(false);
		TimerTask t1 = new Working();
		TimerTask t2 = new Working();
		timer.schedule(t1, new Date(System.currentTimeMillis() + 2000),1000);
		timer.schedule(t2, new Date(System.currentTimeMillis() + 2000));
		t2.cancel();
	}
}
