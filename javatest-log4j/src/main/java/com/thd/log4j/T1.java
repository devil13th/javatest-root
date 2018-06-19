package com.thd.log4j;

import org.apache.log4j.Logger;

public class T1 {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(T1.class);
		log.info("我是第一个LOG");
		
		Logger log2 = Logger.getLogger("myLogger");
		log2.info("我是第二个LOG");
	}

}
