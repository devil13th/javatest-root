package com.thd.freemarker.custom;

import java.io.IOException;
import java.io.Writer;

public class MyWriter extends Writer {
	private final Writer out;
	
	public MyWriter(Writer out) {  
		this.out = out;  
	} 


	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(char[] arg0, int arg1, int arg2) throws IOException {
		String r = new String(arg0);
		out.write(r + " -_-!!!");
	}

}
