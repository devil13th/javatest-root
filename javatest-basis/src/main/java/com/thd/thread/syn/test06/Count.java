/** 
 * Class Description:########
 * Date : 2018年3月20日 上午10:59:57
 * Auth : ccse 
*/  

package com.thd.thread.syn.test06;

public class Count {
	private int ct ;
	private String name;
	public void count(){
		for(int i = 0 ; i < 10 ; i++){
			ct += 1;
			System.out.println(ct + this.name + "|" + Thread.currentThread().getName());
		}
		
	}
}
