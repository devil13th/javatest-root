/** 
 * Class Description:########
 * Date : 2018年4月10日 下午11:50:26
 * Auth : ccse 
*/  

package com.thd.jvm.memoryassign;

public class JvmParamForGc {

	/**
	 * jvm 参数：-verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC
	 * 
	 * -XX:+PrintGCDetails:程序运行完成展示内存分配情况
	 * -Xms20M:最小堆内存
	 * -Xmx20M:最大堆内存
	 * -Xmn10M:新生代内存大小
	 * -XX:SurvivorRatio=8 : Eden/Survivor(单个) 比例
	 * -XX:+UseSerialGC :使用Serial垃圾回收器
	 * 
	 */
	public static void main(String[] args){
		byte[] b = new byte[9 * 1024 * 1024];//10M 空间
		System.out.println("finish");
	}

}
