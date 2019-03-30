package com.thd.thread.api.t04lock.t01;

public class Thread01 implements Runnable {
	public Counter ct ;
	public String type ;
	
	public Thread01(Counter ct,String type){
		this.ct = ct;
		this.type = type;
	}
	
	public void exit(){
		this.ct.exit();
	}
	@Override
	public void run() {
		
		if("add".equals(this.type)){
			ct.add();
		}else{
			ct.substract();
		}
		

	}

}
