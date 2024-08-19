package com.ahmete.ThreadBaslangıc;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		MyThread myThread1=new MyThread("myThread1");
		MyThread myThread2=new MyThread("myThread1");
		myThread1.start();
		myThread2.start();
		
		System.out.println("Thread adı: "+Thread.currentThread().getName());
		for (int i = 0; i <10 ; i++) {
			System.out.println(i);
//			Thread.sleep(1000);
			
		}
		
	}
}