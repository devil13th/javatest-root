package com.thd.zip;

import junit.framework.TestCase;

import org.junit.Test;

public class JavaZipTester extends TestCase{
	@Test
	public void test01(){
		ZipCompressor zc = new  ZipCompressor("E:\\szsshzip.zip");  
		zc.compress("E:\\test");
	}

}
