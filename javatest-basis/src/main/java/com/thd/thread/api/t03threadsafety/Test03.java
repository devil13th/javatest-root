package com.thd.thread.api.t03threadsafety;

public class Test03 {

	public static void main(String[] args) {
		Web1230603 web = new Web1230603();
		int robotNum = 2;
		for(int i = 0 ; i < robotNum ; i++) {
			Thread t = new Thread(web,"robit_" + i);
			t.start();
		}
		//输出结果如下
		/*
		robit_0抢到第[10]张票
		robit_1抢到第[9]张票
		robit_0抢到第[8]张票
		robit_1抢到第[7]张票
		robit_1抢到第[6]张票
		robit_0抢到第[6]张票
		robit_0抢到第[4]张票
		robit_1抢到第[4]张票
		robit_0抢到第[2]张票
		robit_1抢到第[2]张票
		robit_0抢到第[0]张票
		*/
		//很明显同时抢到了4 和 2
	}

}
