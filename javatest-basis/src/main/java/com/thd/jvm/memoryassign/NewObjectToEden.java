/** 
 * Class Description:########
 * Date : 2018年4月10日 下午11:07:37
 * Auth : ccse 
*/  

package com.thd.jvm.memoryassign;

public class NewObjectToEden {
	/**
	 * 新对象进入Eden区
	 * jvm 参数：-verbose:gc -XX:+PrintGCDetails -Xms200M -Xmx200M -XX:+UseSerialGC
	 * Method Description : ########
	 * @param args
	 */
	public static void main(String[] args){
		byte[] b = new byte[10 * 1024 * 1024];//10M 空间
	}
}
