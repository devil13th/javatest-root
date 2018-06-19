/** 
 * Class Description:########
 * Date : 2018年3月21日 下午11:04:22
 * Auth : ccse 
*/  

package com.thd.thread.bjsxt.test03;

public class Web12306 implements Runnable{
	private int ticketNum = 50;
	
	public void run(){
		while(true){
			if(ticketNum <= 0){
				break;
			}
			if(ticketNum <2){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + ":抢到了" +ticketNum--);
			
		}
	}
	
	/**
	 * 执行时偶然会出现抢到同一张票的结果 或 抢到-1的情况，例如
	 * 
	 *  李四:抢到了50
		王五:抢到了49
		张三:抢到了49
		王五:抢到了47
		李四:抢到了48
		王五:抢到了45
		张三:抢到了46
		王五:抢到了43
		李四:抢到了44
		王五:抢到了41
		王五:抢到了39
		王五:抢到了38
		王五:抢到了37
		张三:抢到了42
		张三:抢到了35
		张三:抢到了34
		王五:抢到了36
		李四:抢到了40
		王五:抢到了32
		王五:抢到了30
		张三:抢到了33
		王五:抢到了29
		李四:抢到了31
		王五:抢到了27
		张三:抢到了28
		王五:抢到了25
		李四:抢到了26
		王五:抢到了23
		张三:抢到了24
		王五:抢到了21
		李四:抢到了22
		王五:抢到了19
		张三:抢到了20
		王五:抢到了17
		李四:抢到了18
		王五:抢到了15
		张三:抢到了16
		张三:抢到了13
		张三:抢到了12
		张三:抢到了11
		李四:抢到了14
		李四:抢到了9
		李四:抢到了8
		李四:抢到了7
		李四:抢到了6
		李四:抢到了5
		李四:抢到了4
		李四:抢到了3
		李四:抢到了2
		李四:抢到了1
		张三:抢到了10
		王五:抢到了0


	 * Method Description : ########
	 * @param args
	 */
	public static void main(String[] args){
		Web12306 w = new Web12306();
		Thread t1 = new Thread(w,"张三");
		Thread t2 = new Thread(w,"李四");
		Thread t3 = new Thread(w,"王五");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}
