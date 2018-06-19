package com.thd.utils;

import junit.framework.TestCase;

import org.junit.Test;

public class MyMd5UtilsTest extends TestCase {
	@Test
	public void testencoderByMd5() throws Exception{
		String str = "devil13th";
		System.out.println(MyMd5Utils.encoderByMd5(str));
		
	}
}

