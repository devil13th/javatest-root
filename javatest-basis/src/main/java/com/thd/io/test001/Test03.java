/** 
 * Class Description:########
 * Date : 2018年3月22日 上午10:00:47
 * Auth : ccse 
*/  

package com.thd.io.test001;

import junit.framework.TestCase;

import org.junit.Test;
/**
 * 产生乱码的两个原因
 * @author ccse
 *
 */
public class Test03 extends TestCase{
	
	@Test
	//测试编码解码的字符集不统一的情况
	public void testCharset()  throws Exception{
		String str = "中国"; //utf-8 (以文件格式为准 -- 记事本打开文件另存时在窗口下方选择编码集)
		//编码 char --> byte
		byte[] data = str.getBytes();
		//编码与解码的字符集相同
		System.out.println(new String(data)); 
		
		//编码解码不统一 产生乱码
		data = str.getBytes("GBK");//设定编码字符集
		System.out.println(new String(data)); 
		
		
		byte[] data2 = "中国".getBytes("GBK");
	    String str2 = new String(data2,"utf-8");
	    System.out.println(str2); 
	}
	
	
	@Test
	//测试字节数不完整
	public void testCharse01t()  throws Exception{
		String str = "中国"; 
		byte[] data = str.getBytes();
		for(int i = 0 , j = data.length ; i < j ; i++){
			System.out.println(new String(data,0,i+1));
		}
		
	}
}
