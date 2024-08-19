package com.ahmete.ThreadBaslangıc;

public class Main4 {
	public static void main(String[] args) {
		
		//Anonymous Inner Type
		String name="Anonymous Thread";
		Thread thread0=new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("\u001B[31m"+name+" isimli thread calıştı\u001B[0m");
				String activeThread = Thread.currentThread().getName();
				for (int i = 0; i <10 ; i++) {
					
					try {
						Thread.sleep(1000);
						System.out.println("\u001B[31m"+i+" : thread: "+activeThread+"\u001B[0m");
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(activeThread+"\u001B[31m"+"Threadi calıştırmayı bitirdi\u001B[0m");
			}
		});
		thread0.start();
		System.out.println("main thread son satır");
		
	}
}