package com.thd.designpattern.singleton.lazy;

public class T {


	public static void main(String[] args) {
		
		//LazySingleton instance2 = new LazySingleton();
		
		LazySingleton instance = LazySingleton.getInstance();
		System.out.println(instance);
		
	}

}
