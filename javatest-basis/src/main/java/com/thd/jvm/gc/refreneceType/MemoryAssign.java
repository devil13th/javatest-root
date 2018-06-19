/** 
 * Class Description:########
 * Date : 2018年4月4日 上午11:24:33
 * Auth : ccse 
*/  

package com.thd.jvm.gc.refreneceType;

public class MemoryAssign {
	/**
	 * JVM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 */
	private static final int _1M = 1024 * 1024;
	public static void testAllocation(){
		byte[] b1,b2,b3,b4;
		b1 = new byte[2 * _1M];
		b2 = new byte[2 * _1M];
		b3 = new byte[2 * _1M];
		b4 = new byte[4 * _1M]; //出现一次MinorGC
		//System.gc();
	}
	
	public static void main(String args[]){
		testAllocation();
	}
}
