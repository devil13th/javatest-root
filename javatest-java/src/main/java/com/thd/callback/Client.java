package com.thd.callback;

import org.junit.Test;

public class Client {
	
	@Test
	public void test01(){
		ICallBack icb = new CallBackImpl();
		IDo ido = new IDo(icb);
		
		String r = ido.hello("thd");
		System.out.println(r);
	}
	
	
	@Test
	public void test02(){
		
		IDo ido = new IDo(new ICallBack(){
			public String helloWorld(String str) {
				return "hello :" + str;
			}
		});
		
		String r = ido.hello("thirdteendevil");
		System.out.println(r);
	}
	
	@Test
	public void test03(){
		IDo ido = new IDo();
		
		ido.setCb(new ICallBack(){
			public String helloWorld(String str) {
				return "hello :" + str;
			}
		});
		String r = ido.hello("devil13th");
		System.out.println(r);
	}
	


}
