package com.thd.basic.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.TestCase;

import org.junit.Test;

public class CharsetTest extends TestCase{
	
	@Test
	/**
	 * 测试内容：
	 * 默认编码
	 * 字符集静态常量
	 * 乱码现象
	 */
	public  void test01() {
		String str = "测试数据";
		byte[] b = str.getBytes(Charset.defaultCharset());
		// 获得JVM默认编码方式
		System.out.println(Charset.defaultCharset());
		System.out.println(StandardCharsets.UTF_8);
		
		String str1 = new String(b,StandardCharsets.ISO_8859_1);
		String str2 = new String(b,StandardCharsets.UTF_8);
		System.out.println(str1);
		System.out.println(str2);
	}
	
	@Test
	/**
	 * 测试内容:
	 * 本机支持的所有编码方式
	 */
	public void test02(){
		// 获得本机所有编码格式
	    Map<String, Charset> charsets = Charset.availableCharsets();
	    // 迭代遍历出编码方式
	    for (Entry<String, Charset> entry : charsets.entrySet()) {
	        System.out.println(entry.getKey() + " : " + entry.getValue().name());
	    }
	}
	
	@Test
	/**
	 * 测试内容：
	 * 编码和解码
	 */
	public void testEncoderAndDecoder() throws Exception{
		//使用Charset进行编码和解码
	    CharsetEncoder encoder=Charset.forName("GBK").newEncoder();
	    CharsetDecoder decoder=Charset.forName("GBK").newDecoder();

	    ByteBuffer byteBuffer=encoder.encode(CharBuffer.wrap("中国编码".toCharArray()));

	    CharBuffer charBuffer=decoder.decode(byteBuffer);
	    String string=charBuffer.toString();

	    System.out.println(string);
	}

}
