package com.thd.thread.objectlock.t01;

public class Study implements Runnable{
	private Room room;
	public Study(Room room) {
		this.room = room;
	}
	public void run() {
		this.study(this.room);
	}
    public void study(Room room) {
		synchronized(room) {
			for(int i = 0 , j = 5 ; i < j ; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" 上课 " + room.toString());
			}
		}
	}

}
