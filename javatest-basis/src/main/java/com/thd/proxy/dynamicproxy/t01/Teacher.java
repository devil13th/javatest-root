package com.thd.proxy.dynamicproxy.t01;

public class Teacher implements People {

	@Override
	public String prt() {
		System.out.println(" 根本方法调用 ");
		return "success";
	}

}
