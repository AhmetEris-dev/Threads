package com.ahmete.ThreadSorunlar;

public class ThreadCozum1 {
	// Çözüm 1: synchronized blok kullanımı
	
	private  static int sayac=0;
	
	public static void sayacArtir(){
		synchronized (ThreadCozum1.class){
			sayac++;
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