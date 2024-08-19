package com.ahmete.ThreadSorunlar;

public class ThreadSorun3 {
	
	// Volatile: bir değişkenin değeri direkt olarak bellekten alınması istendiğinde kullanılır.
	//İşlemci cache mekanizması var
	//burada vilatile keywordü ile bu değişkenin işlemci cachelerinde tutulması engellenir.
	//değeri direkt olarak ram bellekte getirilir
	
	public static volatile boolean flag=false;
	
	public static void main(String[] args) {
		Thread thread1=new Thread(()->{
			System.out.println("Thread1 calıştı");
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag=true;
			System.out.println("Flag değer true yapıldı");
		});
		
		Thread thread2=new Thread(()->{
			System.out.println("Thread2 calıştı");
			while (!flag){
				System.out.println("Thread 2 while bloğu calıştır ");
			}
			System.out.println("Flag değeri true oldu");
		});
		thread1.start();
		thread2.start();
		
	}
}