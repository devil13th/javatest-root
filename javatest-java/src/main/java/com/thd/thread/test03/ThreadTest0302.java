package com.thd.thread.test03;

public class ThreadTest0302 {
	public static void main(String[] args) {
		
		
		final Bean01 b = new Bean01();
		new Thread() {
			public void run() {
				for(int i = 1 , j = 500  ; i <= j ; i ++){
//					int ct = b.c;
//					ct++;
//					ct++;
//					ct++;
//					b.c = ct;
//					System.out.println("a:"+i+"===" + b.c);
					System.out.println("===a" + i);
					System.out.println("===a" + i);
					System.out.println("===a" + i);
					System.out.println("===a" + i);
				}
			};
		}.start();

		new Thread() {
			public void run() {
				for(int i = 1 , j = 500  ; i <= j ; i ++){
//					int ct = b.c;
//					ct--;
//					ct--;
//					ct--;
//					b.c = ct;
//					System.out.println("b:"+i+"===" + b.c);
					System.out.println("---b" + i);
					System.out.println("---b" + i);
					System.out.println("---b" + i);
					System.out.println("---b" + i);
				}
			};
		}.start();
		
		
		
		
	}

}
