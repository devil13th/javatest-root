package com.thd.designpattern.singleton.hungry;

public class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();
	private HungrySingleton(){
		
	}
	
	public static HungrySingleton getInstance(){
		return instance;
	}
}
