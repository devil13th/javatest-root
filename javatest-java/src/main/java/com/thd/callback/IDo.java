package com.thd.callback;

public class IDo {
	private ICallBack cb;

	public ICallBack getCb() {
		return cb;
	}

	public void setCb(ICallBack cb) {
		this.cb = cb;
	}
	
	public String hello(String str){
		return this.cb.helloWorld(str);
	}
	
	public  IDo(){};
	public  IDo(ICallBack cb){
		this.cb = cb;
	}
}
