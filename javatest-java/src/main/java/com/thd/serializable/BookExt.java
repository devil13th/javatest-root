package com.thd.serializable;

import java.io.Serializable;

public class BookExt implements  Serializable {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	private String name;  
	      
	    private Author author;  
	      
	    public BookExt(String name,Author author)  
	    {  
	        this.name=name;  
	        this.author=author;  
	    }  

}
