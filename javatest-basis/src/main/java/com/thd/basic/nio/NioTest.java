package com.thd.basic.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import junit.framework.TestCase;

import org.junit.Test;

public class NioTest extends TestCase {
	
	@Test
	public void testBuffer(){
		//1.分配缓冲区
		//分配了一个长度为10的缓冲区 (数组)
		ByteBuffer buffer = ByteBuffer.allocate(10);
		System.out.println("-------- allocate(10) -------");
		//缓冲区的容量是10
		System.out.println(buffer.capacity()); //10
		//缓冲区中可读写的数量为10
		System.out.println(buffer.limit()); // 10
		//缓冲区中当前的操作位置是0
		System.out.println(buffer.position()); //0
		
		//2.写数据
		
		//目前buffer处在写数据模式
		String str = "abcde";
		//将数据存到缓冲区中 (这里保存了5个字节)
		buffer.put(str.getBytes());
		System.out.println("------- put() --------");
		//缓冲区的容量是10
		System.out.println(buffer.capacity()); //10
		//缓冲区中可读写的数量为10
		System.out.println(buffer.limit()); // 10
		//缓冲区中当前的操作位置是5  因为写入了5个字节,占用了数组的前0-4的位置
		System.out.println(buffer.position()); //5
		
		
		//3.切换到读取模式
		
		System.out.println("------- flip() --------");
		//buffer切换到读数据模式
		buffer.flip();
		//缓冲区的容量是10
		System.out.println(buffer.capacity()); //10
		//缓冲区中可读写的数量为5  因为切换到读数据模式,只能读已写入的位置(数组的0-4)
		System.out.println(buffer.limit()); //5
		//缓冲区中当前的操作位置是0 
		System.out.println(buffer.position()); //0
		
		
		//4.读取缓冲区中的数据
		System.out.println("------- get() --------");
		byte[] b = new byte[buffer.limit()];
		//读取数据
		buffer.get(b);
		//输出读取的内容
		System.out.println(new String(b));
		//缓冲区的容量是10
		System.out.println(buffer.capacity()); //10
		//缓冲区中可读写的数量为5  因为切换到读数据模式,只能读已写入的位置(数组的0-4)
		System.out.println(buffer.limit()); //5
		//缓冲区中当前的操作位置是5 (已读取了数组中0-4个元素,position指到数组中第5个位置)
		System.out.println(buffer.position()); //5
		
		
		//5.rewind 可重复读数据
		
		System.out.println("------- rewind() --------");
		buffer.rewind();
		//缓冲区的容量是10
		System.out.println(buffer.capacity()); //10
		//缓冲区中可读写的数量为5  因为切换到读数据模式,只能读已写入的位置(数组的0-4)
		System.out.println(buffer.limit()); //5
		//缓冲区中当前的操作位置是5 (已读取了数组中0-4个元素,position指到数组中第5个位置)
		System.out.println(buffer.position()); //5
		
		
		//6.clear 清空缓冲区(注意:缓冲区中的数据依然存在,这不过这些数据处于被遗忘状态)
		System.out.println("------- rewind() --------");
		buffer.clear();
		//缓冲区的容量是10
		System.out.println(buffer.capacity()); //10
		//缓冲区中可读写的数量为10 因为缓冲区已被清空
		System.out.println(buffer.limit()); //5
		//缓冲区中当前的操作位置是0 因为缓冲区已被清空
		System.out.println(buffer.position()); //5
	}
	
	@Test
	//直接缓冲区复制文件
	public void testChannel() throws Exception{
		//创建通道
		/*
		 * 读模式
		 * StandardOpenOption.READ
		 * 
		 * 写模式
		 * StandardOpenOption.WRITE
		 * 
		 * 如果不存在则创建,如果文件存在也会创建(覆盖)
		 * StandardOpenOption.CREATE
		 * 
		 * 如果文件不存在则创建,如果文件存在则报错
		 * StandardOpenOption.CREATE_NEW
		 * 
		*/
		FileChannel inChannel = FileChannel.open(Paths.get("D:", "jquery.min.js"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("D:", "jquery2.min.js"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		//创建一个直接缓存区(该缓存区在物理内存中而不是JVM内存区)
		//直接缓存区只支持ByteBuffer
		ByteBuffer inMapBuffer = inChannel.map(MapMode.READ_ONLY, 0,inChannel.size());
		ByteBuffer outMapBuffer = outChannel.map(MapMode.READ_WRITE,0, inChannel.size());
		
		//直接缓冲区只需要从缓存区中读取数据或将数据直接写到缓冲区即可,直接对缓存区进行数据读写操作
		byte[] b = new byte[inMapBuffer.limit()];
		inMapBuffer.get(b);
		
		outMapBuffer.put(b);
		
		inChannel.close();
		outChannel.close();
		
	}
	
	@Test
	//直接缓冲区复制文件
	public void testChannelTransfer() throws Exception{
		FileChannel inChannel = FileChannel.open(Paths.get("D:", "jquery.min.js"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("D:", "jquery2.min.js"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		//inChannel.transferTo(0, inChannel.size(), outChannel);
		outChannel.transferFrom(inChannel,0, inChannel.size());
		inChannel.close();
		outChannel.close();
		
	}
	
	@Test
	public void test01() throws Exception{
		RandomAccessFile aFile = new RandomAccessFile("d://jquery.min.js", "rw");
		//创建通道
		FileChannel channel = aFile.getChannel();
		//创建缓冲区  容量为1024字节
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		//将数据读取到缓冲区  channel.read(buffer)返回读取的字节数 文件读完则返回-1 
		int readByte = channel.read(buffer);
		while(readByte != -1){
			System.out.println("Read " + readByte);
			//make buffer ready for read
			//写状态 切换到 读状态
			buffer.flip();
			
			while(buffer.hasRemaining()){
				//read 1 byte at a time 获取缓冲区的数据
		        System.out.print((char)buffer.get());
		    }
			
			//清除整个缓冲区
			buffer.clear();
			//compact()方法只清除已经读过的数据
			//buffer.compact();
			
			
		    readByte = channel.read(buffer);
		}
		channel.close();
		aFile.close();
		
	}
}
