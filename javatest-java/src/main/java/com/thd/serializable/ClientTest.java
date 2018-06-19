package com.thd.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class ClientTest {
	@Test
	public void test01() throws Exception{
		//演示一：最简单的序列化例子  
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("d:/deleteme/cxyapi.data"));  
        Book b1=new Book("Java教程");  
        oos.writeObject(b1);  
        oos.close();  
          
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("d:/deleteme/cxyapi.data"));  
        Book b2=(Book)ois.readObject();  
        System.out.println(b2.getName());  
        ois.close();  
        System.out.println("=====================");  
	}
	
	@Test
	public void test02() throws Exception{
		 //演示二：一个包含其他对象的对象  
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("d:/deleteme/cxyapi.data"));  
	       
        oos=new ObjectOutputStream(new FileOutputStream("d:/deleteme/cxyapi.data"));  
        Author a=new Author("cxy");  
        //点1：两本书我存同一个对象(作者)  
        BookExt be=new BookExt("cxyapi", a);  
        BookExt be1=new BookExt("snkcxy.iteye.com", a);  
        oos.writeObject(be);  
        //点2：我存2遍be1  
        oos.writeObject(be1);  
        oos.writeObject(be1);  
        oos.close();  

        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("d:/deleteme/cxyapi.data"));  
        ois=new ObjectInputStream(new FileInputStream("d:/deleteme/cxyapi.data"));  
        //存3个对象 我取3个对象,多取会报错  
        BookExt bec=(BookExt)ois.readObject();  
        BookExt be1c=(BookExt)ois.readObject();  
        BookExt be1cc=(BookExt)ois.readObject();  
        System.out.println(bec.getName());  
        System.out.println(be1c.getName());  
        System.out.println(be1cc.getName());  
        //判断最后2个对象 其实是一个对象，这是Java序列化机制所知，它不会一下序列化出很多同样的对象  
        System.out.println(be1c==be1cc);  
        System.out.println(be1c.hashCode());  
        System.out.println(be1cc.hashCode());  
        //判断作者，其实也是同一个对象  
        System.out.println(bec.getAuthor()==be1c.getAuthor());  
        System.out.println(bec.getAuthor().hashCode());  
        System.out.println(be1c.getAuthor().hashCode());  
        ois.close();  
        System.out.println("=====================");  
	}
}
