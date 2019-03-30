package com.thd.thread.api.t11state;

public class T01 {
	/**
	 * 线程的几种状态
	 * 
	 * NEW            已创建未执行
	 * TIMED_WAITING  等待中
	 * RUNNABLE       运行中
	 * BLOCKED        阻塞
	 * TERMINATED	     已中止
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new Thread01(1));
		System.out.println(t.getState().toString());
		t.start();
		String oldState = t.getState().toString();
		String newState = t.getState().toString();
		System.out.println(oldState);
		while(true){
			newState = t.getState().toString();
			if(!oldState.equals(newState)){
				System.out.println(oldState + " --- " + newState);
			}
			oldState = newState;
			
			if(newState.equals("TERMINATED")){
				break;
			}
			
			
		}
		System.out.println(" --------- finish -----------");

	}

}
