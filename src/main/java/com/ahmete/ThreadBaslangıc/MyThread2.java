package com.ahmete.ThreadBaslangıc;

public class MyThread2 extends Thread{
	private String name;
	
	public MyThread2(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println("\u0018[31m"+name+" isimli thread calıştı");
		String activeThread = Thread.currentThread().getName();
		for (int i = 0; i <10 ; i++) {
			
			try {
				Thread.sleep(1000);
				System.out.println("\u0018[31m"+i+" : thread: "+activeThread);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(activeThread+"\u0018[31m"+"Threadi calıştırmayı bitirdi");
	}
}