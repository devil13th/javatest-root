package com.thd.designpattern.proxy.exam;

public class Client {

	
	public static void main(String[] args) {
		Talk t = new Person("张三",5);
		t.talk("hello world");
		System.out.println("============");
		Talk p = new Person("李四",3);
		TalkProxy proxy = new TalkProxy(p);
		proxy.sing("国歌");
	}

}
