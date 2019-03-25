package com.thd.io.test001;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import junit.framework.TestCase;

import org.junit.Test;

public class InputStreamTest extends TestCase {
	@Test
	public void test01(){
		
		InputStream is = null;
		int len = 0;
		try{
			File f = new File("D://test/a.txt");
			is = new FileInputStream(f);
			byte[] car = new byte[1];
			while( -1 != (len = is.read(car))){
				System.out.println(new String(car, "UTF-8") );
			}
		}catch(Exception e){
			try{
				is.close();
			}catch(IOException iox){
				System.out.println("InputStream close error !");
			}
			
			e.printStackTrace();
		}finally{
			if(is != null){
				try{
					is.close();
					System.out.println(" InputStream has closed");
				}catch(Exception iox){
					System.out.println(" InputStream close error !");
				}
			}
		}
		
	}
	
	
	
	@Test
	public void test02(){
		
		Reader is = null;
		int len = 0;
		try{
			File f = new File("D://test/a.txt");
			is = new FileReader(f);
			char[] car = new char[1];
			while( -1 != (len = is.read(car))){
				System.out.println(new String(car) );
			}
		}catch(Exception e){
			try{
				is.close();
			}catch(IOException iox){
				System.out.println("InputStream close error !");
			}
			
			e.printStackTrace();
		}finally{
			if(is != null){
				try{
					is.close();
					System.out.println(" InputStream has closed");
				}catch(Exception iox){
					System.out.println(" InputStream close error !");
				}
			}
		}
		
	}
	
	@Test
	public void test03(){
		File f = null;
		InputStream is = null;
		InputStream bis = null;
		
		
		try{
			f = new File("D://jquery.min.js");
		}catch(Exception e){
			System.out.println(" new File errors ");
			return;
		}
		
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			System.out.println(" new FileInputStream errors ");
			return;
		}
		
		
		bis = new BufferedInputStream(is);
		
		byte[] buffer = new byte[8 * 1024 ]; //8M
		int len = 0;
		try {
			while(  (len = bis.read(buffer)) != -1){
				for(int i = 0 , j = buffer.length ; i < j ; i++){
					System.out.print((char)buffer[i]);
				}
				
			}
		} catch (IOException e) {
			System.out.println(" error ");
			
		}finally{
			
			try{
				if(bis != null){
					bis.close();
				}
			}catch(Exception e){
				System.out.println("关闭文件流失败");
			}
			
			try{
				if(is != null){
					bis.close();
				}
			}catch(Exception e){
				System.out.println("关闭文件流失败");
			}
		}
		
		
				
		
	}
}
