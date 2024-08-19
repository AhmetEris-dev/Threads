package com.ahmete.ThreadBaslangıc;

public class Main2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		MyThread myThread1=new MyThread("myThread1");
		MyThread2 myThread2=new MyThread2("myThread1");
		myThread1.start();
		myThread2.start();
		
		myThread2.join();// main thread'de join edilen thread işlemi bitirene kadar bekler
		//alttaki satırlar mythread2 işini bitirdikten sonra ulaşur
		
		
		
		
		
		String  activeThread = Thread.currentThread().getName();
		System.out.println(activeThread+" myThread2 calıştı");
		
	}
}