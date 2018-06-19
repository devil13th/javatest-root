/** 
 * Class Description:########
 * Date : 2018年4月10日 下午11:46:31
 * Auth : ccse 
*/  

package com.thd.jvm.memoryassign;

public class BigObjectToOld {

	/**
	 * 大对象直接进入老年代
	 * jvm 参数：-verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=2M
	 * -XX:+PrintGCDetails:程序运行完成展示内存分配情况
	 * -Xms20M:最小堆内存
	 * -Xmx20M:最大堆内存
	 * -Xmn10M:新生代内存大小 
	 * -XX:SurvivorRatio=8 : Eden/Survivor(单个) 比例
	 * -XX:+UseSerialGC :使用Serial垃圾回收器
	 * -XX:PretenureSizeThreshold=2M : 大于2M的对象直接分配到老年代,
	 */
	public static void main(String[] args){
		byte[] b = new byte[3 * 1024 * 1024];//10M 空间
	}

}
