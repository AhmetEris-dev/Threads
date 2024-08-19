package com.ahmete.ThreadSorunlar;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Lock Kullanmak: Kilit mekanizması
Lock kullanarak bir thread tarafından ulaşılan metoda başka bir thread erişimi o anlık engellenir.
 */
public class ThreadCozum2 {
	private  static int sayac=0;
	
	private static Lock lock=new ReentrantLock();
	
	public static void sayacArtir(){
		try {
			lock.lock();
			sayac++;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread1=new Thread(()->{
			for (int i = 0; i <5000 ; i++) {
				sayacArtir();
			}
			System.out.println("Thread1 calısmayı bitirdi. sayac= "+sayac);
		});
		Thread thread2=new Thread(()->{
			for (int i = 0; i <5000 ; i++) {
				sayacArtir();
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