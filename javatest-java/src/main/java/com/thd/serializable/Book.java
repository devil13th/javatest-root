package com.thd.serializable;

import java.io.Serializable;

public class Book implements  Serializable  {
	 private static final long serialVersionUID = -564380176443249810L;  
	     private String name;  
	       
	    public Book(String name)  
	     {  
	         this.name=name;  
	     }  
	   
	     public String getName()  
	     {  
	         return name;  
	     }  
	   
	     public void setName(String name)  
	     {  
	         this.name = name;  
	     }  

}
