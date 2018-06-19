/** 
 * Class Description:########
 * Date : 2018年3月22日 上午8:38:46
 * Auth : ccse 
*/  

package com.thd.io.test001;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;


public class Test01 extends TestCase {
	
	@Test 
	public void testFileInputStream() {
		String filePath = "D:" + File.separator + "a.txt";
		File f = new File(filePath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			byte[] car = new byte[15]; //缓冲数组 
			int len  = 0; //接收实际读取大小 
			while(-1 != (len = fis.read(car))){ 
				//输出  字节数组转成字符串  
				//因为是按照15个字节数组一次一次读取，故有可能读取半个文字 所以文件终会出现乱码
				String str = new String(car,0,len); 
				System.out.println(str);
			}
			
			System.out.println(fis);
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
			if(null != fis){
				try {
					fis.close();
				} catch (IOException ex) {
					System.out.println("关闭输入流失败");
					ex.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			System.out.println("文件大小");
			e.printStackTrace();
		} finally{
			if(null != fis){
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("关闭输入流失败");
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("FINISH");
	}
	
	
	
	@Test 
	public void testFileOutStream() {
		String filePath = "D:" + File.separator + "f.txt";
		File f = new File(filePath);
		FileOutputStream fos = null;	
		System.out.println(fos);
		String str = "hello world !! \r\n";
		
		try {
			fos = new FileOutputStream(filePath);
			byte[] car = str.getBytes();
			int len = 0;
				fos.write(car,0,car.length);
				fos.flush();
		} catch (FileNotFoundException e1) {
			System.out.println("文件不存在");
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("文件输出失败");
		}
		
		System.out.println("FINISH");
	}
	
	
	@Test 
	public void testCopyFile() {
		String sFile = "D:" + File.separator + "f.txt";
		String dFile = "D:" + File.separator + "e.txt";
		
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(sFile);
			fos = new FileOutputStream(dFile);
			
			byte[] car = new byte[1024];
			int len = 0;
			while(-1 != (len = fis.read(car))){
				fos.write(car, 0, len);
			}
			fos.flush();
			
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
		} catch (IOException e) {
			System.out.println("文件读取失败");
		} finally{
			if(null!=fos){
				try {
					fos.close();
				} catch (IOException e) {
					System.out.println("关闭输出流失败");
				}
			}
			
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("关闭输入流失败");
			}
			
		}
			
		System.out.println("FINISH");
		
	}
}
