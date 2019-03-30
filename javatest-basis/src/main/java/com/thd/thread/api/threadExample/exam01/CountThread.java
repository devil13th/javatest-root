package com.thd.thread.api.threadExample.exam01;

import java.util.ArrayList;
import java.util.List;

public class CountThread implements Runnable {
	private List l = new ArrayList();
	
	public List getL() {
		return l;
	}
	public void setL(List l) {
		this.l = l;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	private int count = 100;
	public CountThread(int i){
		this.count = i;
	}
	@Override
	public void run() {
		while(l.size() < this.count){
			synchronized(l){
				l.add(l.size());
				System.out.println(Thread.currentThread().getName() + " " + l.size());
			}
		}

	}

}
