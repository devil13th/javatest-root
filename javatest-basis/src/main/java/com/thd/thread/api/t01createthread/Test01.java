package com.thd.thread.api.t01createthread;

public class Test01 {

	public static void main(String[] args) {
		//Web12306通过实现Runnable接口实现线程 － 推荐
		Web1230601 w = new Web1230601();
		Thread t = new Thread(w,"张三");
		t.start();

	}

}
