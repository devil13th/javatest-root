/** 
 * Class Description:########
 * Date : 2018年3月22日 上午9:20:21
 * Auth : ccse 
*/  

package com.thd.io.test001;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import junit.framework.TestCase;

import org.junit.Test;

public class Test02 extends TestCase {
	@Test 
	public void testReader() {
		String filePath = "D:" + File.separator + "f.txt";
		Reader r = null;
		try {
			r = new FileReader(filePath);
			char[] car =  new char[1024];
			int len = 0;
			while(-1 != (len = r.read(car))){
				 System.out.print(new String(car,0,len));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		} catch (IOException e) {
			System.out.println("文件读取错误");
		} finally{
			try {
				r.close();
			} catch (IOException e) {
				System.out.println("输入流关闭失败");
			}
		}
		System.out.println("FINISH");
	}
	
	
	@Test 
	public void testWiter() {
		String filePath = "D:" + File.separator + "h.txt";
		Writer r = null;
		try {
			String str = "世界\r\n你好!";
			r = new FileWriter(filePath);
			r.write(str);
			r.flush();
			
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		} catch (IOException e) {
			System.out.println("文件读取错误");
		} finally{
			try {
				r.close();
			} catch (IOException e) {
				System.out.println("输入流关闭失败");
			}
		}
		System.out.println("FINISH");
	}
	
	
	@Test 
	public void testcopyTxt() throws Exception{
		String sFilePath = "D:" + File.separator + "h.txt";
		String dFilePath = "D:" + File.separator + "i.txt";
	
		Reader sFile = new FileReader(sFilePath);
		Writer dFile = new FileWriter(dFilePath);
		
		char[] car = new char[1];
		int len = 0;
		while(-1 != (len = sFile.read(car))){
			String s = new String(car,0,len);
			System.out.print(s);
			dFile.write(car, 0, len);
		}
		dFile.flush();
		dFile.close();
		sFile.close();
		System.out.println("FINISH");
	
	}	
}
