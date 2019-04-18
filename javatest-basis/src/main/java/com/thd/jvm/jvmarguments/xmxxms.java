package com.thd.jvm.jvmarguments;

public class xmxxms {
	
	public static void test01(){
		//jvm 参数：-Xmx200m -Xms100m
				//指定java堆最大值（默认值是物理内存的1/4(<1GB)）和初始java堆最小值（默认值是物理内存的1/64(<1GB))
				System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");     //系统的最大空间
				System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");   //系统的空闲空间
				System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");   //当前可用的总空间
			/**
		Xmx=178.0M
		free mem=98.71292877197266M
		total mem=99.5M
			 */
		
	}
	
	public static void test02(){
		//jvm 参数：-Xmx200m -Xms100m
		//指定java堆最大值（默认值是物理内存的1/4(<1GB)）和初始java堆最小值（默认值是物理内存的1/64(<1GB))
		
		byte[] b = new byte[500 * 1024 * 1024];
		
		byte[] b1 = new byte[50 * 1024 * 1024];
		
		System.out.println("分配了5M空间给数组");
		System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");   //系统的最大空间
		System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");   //系统的空闲空间
		System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");  
			/**
		分配了1M空间给数组
		Xmx=178.0M
		free mem=48.72454071044922M
		total mem=99.5M
			 */
	}
	public static void main(String[] args) {
		test01();
		test02();
		
		while(true){
			
		}
		/**
		 * jvm 参数设置：
		 * -Xmx200m -Xms50m -XX:+PrintHeapAtGC -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/deleteme/a.dump -Xloggc:D:/deleteme/app_gc.log -verbose:gc
		 */
		
		/**
输出
Xmx=178.0M
free mem=48.72063446044922M
total mem=49.5M
分配了5M空间给数组
Xmx=178.0M
free mem=33.720603942871094M
total mem=134.5M
		 */
		
		//注意上面输出,free mem从98.712M变为了48.712M 减少的50M就是 byte[] b = new byte[50 * 1024 * 1024]; 占用的
		//total mem 从
	}

}
