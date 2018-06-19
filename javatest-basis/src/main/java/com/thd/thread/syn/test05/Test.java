/** 
 * Class Description:########
 * Date : 2018年3月15日 下午5:23:45
 * Auth : ccse 
*/  

package com.thd.thread.syn.test05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	public static void main(String[] args){
		WriteFile wf = new WriteFile();
		Thread t1 = new Thread(wf,"Thread - 001");
		Thread t2 = new Thread(wf,"Thread - 002");
		t1.start();
		t2.start();
	}
	
	
	
}


class WriteFile implements Runnable{
	
	public void run() {
		synchronized(this){
			String str = "|| 1234567890" + Thread.currentThread().getName() + " || ";
			WriteFileUtil.TextToFile("D://aa.txt", str);
		}
	}
	
}


class WriteFileUtil {
	static public void TextToFile(final String strFilename, final String strBuffer) {  
		try{      
			// 创建文件对象  
			File fileText = new File(strFilename);  
			// 向文件写入对象写入信息  
			FileWriter fileWriter = new FileWriter(fileText);  
			  
			// 写文件        
			fileWriter.write(strBuffer);  
			// 关闭  
			fileWriter.close();  
		}  
		catch (IOException e){  
			e.printStackTrace();  
		}  
	}
}