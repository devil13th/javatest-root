package com.thd.thread.api.t07wait.t01;

public class Test01 {
	public static void main(String[] args) throws InterruptedException {
		Basket basket = new Basket();
		Producer p1 = new Producer("张三1",basket);
		Producer p2 = new Producer("张三2",basket);
		Consumer c = new Consumer("李四",basket);
		
		Thread tp1 = new Thread(p1);
		Thread tp2 = new Thread(p2);
		Thread tc = new Thread(c);
		tp1.start();
		tp2.start();
		tc.start();
		Thread.sleep(3000);
		System.out.println("finish");
	}
}

class Cake{
	int i ;
	public Cake(int i) {
		this.i = i;
	}
	public String toString() {
		return "CAKE_" + i; 
	}
}

class Basket{
	public Cake[] basket = new Cake[5];
	int i = 0;
	public Cake pop() {
		i--;
		Cake c = basket[i];
		basket[i] = null;
		return c;
	}
	
	public void push(Cake c) {
		basket[i] = c;
		i++;
	}
	
	public int size() {
		return this.i;
	}
}

class Producer implements Runnable{
	private Basket basket;
	private String name;
	public Producer(String name,Basket basket) {
		this.name = name;
		this.basket = basket;
	}
	@Override
	public void run() {
		
		this.makeCake();
		
	}
	
	public void makeCake() {
		synchronized(this.basket) {
			for(int i = 0 , j = 10 ; i < j ; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(this.basket.size() >= this.basket.basket.length) {
					System.out.println(this.name + " 停止生产" + this.basket.size());
					try {
						this.basket.wait();
					} catch (InterruptedException e) {
						System.out.println(Thread.currentThread().getName() +  " " + this.name + " error ");
						e.printStackTrace();
					}
				}
				Cake c = new Cake(i);
				this.basket.push(c);
				System.out.println(this.name + "生产了" + c.toString());
				try {
					this.basket.notify();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}

class Consumer implements Runnable{
	private Basket basket;
	private String name;
	public Consumer(String name,Basket basket) {
		this.name = name;
		this.basket = basket;
	}
	@Override
	public void run() {
		this.eatCake();
		
	}
	public void eatCake() {
		synchronized(this.basket) {
			for(int i = 0 , j = 20 ; i < j ; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(this.basket.size() <= 0) {
					try {
						this.basket.wait();
					} catch (InterruptedException e) {
						System.out.println(Thread.currentThread().getName() +  " " + this.name + " error ");
						e.printStackTrace();
					}
				}
				try {
					this.basket.notify();
				}catch(Exception e) {
					e.printStackTrace();
				}
				Cake c = this.basket.pop();
				System.out.println(this.name + "吃了" + c);
			}
		}
	}
}