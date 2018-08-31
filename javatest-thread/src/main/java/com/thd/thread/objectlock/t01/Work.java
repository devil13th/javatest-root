package com.thd.thread.objectlock.t01;

public class Work implements Runnable{
	private Room room;
	public Work(Room room) {
		this.room = room;
	}
	public void run() {
		this.room.work();
	}
    

}
