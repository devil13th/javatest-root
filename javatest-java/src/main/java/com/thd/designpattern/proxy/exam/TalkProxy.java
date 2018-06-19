package com.thd.designpattern.proxy.exam;

public class TalkProxy implements Talk {
	
	private Talk p;
	
	public TalkProxy(Talk p){
		this.p = p;
	}
	
	public void talk(String msg) {
		p.talk(msg);
	}
	
	public void sing(String msg){
		p.talk(msg);
		System.out.println("唱歌：" + msg);
	}

}
