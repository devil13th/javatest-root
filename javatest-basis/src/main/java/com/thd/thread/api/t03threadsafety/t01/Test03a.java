package com.thd.thread.api.t03threadsafety.t01;

public class Test03a {
	/**
	 * 该例子使用synchronized关键字,在竞争某一资源的时候未出现问题
	 */
	public static void main(String[] args) {
		Web1230603a web = new Web1230603a();
		int robotNum = 2;
		for(int i = 0 ; i < robotNum ; i++) {
			Thread t = new Thread(web,"robit_" + i);
			t.start();
		}
		//输出结果如下
		/*
		robit_0抢到第[10]张票
		robit_1抢到第[9]张票
		robit_1抢到第[8]张票
		robit_0抢到第[7]张票
		robit_0抢到第[6]张票
		robit_1抢到第[5]张票
		robit_0抢到第[4]张票
		robit_1抢到第[3]张票
		robit_0抢到第[2]张票
		robit_1抢到第[1]张票
		robit_0抢到第[0]张票
		*/
		//通过synchronized关键字锁住了this对象,输出正常
	}

}
