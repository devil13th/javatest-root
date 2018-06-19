package com.thd.designpattern.strategy.exam;

public class Reader {
	private ContentReader reader;
	public Reader(ContentReader reader){
		this.reader = reader;
	}
	public String getContent(){
		return reader.read();
	}
}
