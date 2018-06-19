package com.thd.thread.syn.test04;

public class CreateNo implements Runnable {
	private NoService noService;
	
	public CreateNo(NoService ns){
		this.noService = ns;
	}
	
	public void run() {
		for(int i = 0 , j = 10 ; i < j ; i++){
			System.out.println(Thread.currentThread().getName() + ":" + noService.makeNo());
		}
	}
	
	public static void main(String[] args ){
		NoService ns = new NoService();
		CreateNo cn1 = new CreateNo(ns);
		CreateNo cn2 = new CreateNo(ns);
		
		Thread t1 = new Thread(cn1);
		Thread t2 = new Thread(cn2);
		
		t1.start();
		t2.start();
	}
	
	

}

//取号的服务层
class NoService{
	private int no = 0;
	public int makeNo(){
		synchronized(this){
			no++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return no;
		}
	}
	
	
}
