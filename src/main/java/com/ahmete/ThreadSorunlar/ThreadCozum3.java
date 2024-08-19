package com.ahmete.ThreadSorunlar;

import java.util.concurrent.atomic.AtomicInteger;

/*
Atomic sınıflar kullanmak.
 */
public class ThreadCozum3 {
	private  static AtomicInteger sayac=new AtomicInteger(0);
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread1=new Thread(()->{
			for (int i = 0; i <5000 ; i++) {
				sayac.getAndIncrement(); //sayac++'nın karşılıgı
			}
			System.out.println("Thread1 calısmayı bitirdi. sayac= "+sayac);
		});
		Thread thread2=new Thread(()->{
			for (int i = 0; i <5000 ; i++) {
				sayac.getAndIncrement();
			}
			System.out.println("Thread2 calısmayı bitirdi. sayac= "+sayac);
		});
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		System.out.println("main thread calısmayı bitirdi. sayac= "+sayac);
	}
}