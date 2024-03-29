package com.thd.thread.test03;

public class ThreadTest0301 {
	public static void main(String[] args) {  
        final Outputter output = new Outputter();  
        new Thread() {  
            public void run() {  
                output.output("ABCDEFGHIJKLMNOPQRSTUVWXYZ");  
            };  
        }.start();
        
        new Thread() { 
            public void run() {  
                output.output("abcdefghijklmnopqrstuvwxyz");  
            };  
        }.start();  
    }  
}  


	class Outputter {  
    public void output(String name) {  
        // 为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符  
        for(int i = 0; i < name.length(); i++) {  
            System.out.print(name.charAt(i));  
            // Thread.sleep(10);  
        }  
    } 
}
