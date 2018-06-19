package com.thd.log4j;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

public class T1Test extends TestCase {
	Logger log ;
	Logger log2;
	protected void setUp() throws Exception {
		System.out.println("set up ");
		
		log = Logger.getLogger(this.getClass());
		log2 = Logger.getLogger("myLogger");
		
		super.setUp();
	}
	
	public void test001(){
		log.debug("debug:我是第一个LOG ");
		log.info("info:我是第一个LOG ");
		log.warn("warn:我是第一个LOG ");
		log.error("error:我是第一个LOG ");
		log.fatal("fatal:我是第一个LOG ");
		
		
		log2.debug("debug:我是第二个LOG ");
		log2.info("info:我是第二个LOG ");
		log2.warn("warn:我是第二个LOG ");
		log2.error("error:我是第二个LOG ");
		log2.fatal("fatal:我是第二个LOG ");
	}
	
	protected void tearDown() throws Exception {
		System.out.println("tear down ");
		super.tearDown();
	}

}
