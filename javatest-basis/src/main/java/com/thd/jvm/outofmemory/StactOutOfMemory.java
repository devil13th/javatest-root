/** 
 * Class Description:########
 * Date : 2018年4月3日 下午3:40:12
 * Auth : ccse 
*/  

package com.thd.jvm.outofmemory;


public class StactOutOfMemory {
public static int COUNT = 0; 
	
	//递归循环,可以导致StackOverflowError异常
	public void makeStackOverflow(){
		System.out.println(COUNT++);
		makeStackOverflow();
	}
	
	public static void main(String args[]){
		StactOutOfMemory stack = new StactOutOfMemory();
		
		//调用递归循环,可以导致StackOverflowError异常
		stack.makeStackOverflow();
	}
}
