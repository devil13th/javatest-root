package com.thd.designpattern.singleton.hungry;


public class T {


	public static void main(String[] args) {
		
		//HungrySingleton instance2 = new HungrySingleton();
		
		HungrySingleton instance1 = HungrySingleton.getInstance();
		HungrySingleton instance2 = HungrySingleton.getInstance();
		System.out.println(instance1==instance2);
		
	}

}
