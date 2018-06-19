package com.thd.md5;


public class T01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String s = MyDM5.getMd5("000000");
		System.out.println(s);
		//123456 e10adc3949ba59abbe56e057f20f883e
		//123452 7692dcdc19e41e66c6ae2de54a696b25
		//000000a 249e540dbbe67b579b5d96d985c8b419
	}

}
