package com.ahmete.ThreadBaslangıc;

public class Main6 {
	public static void main(String[] args) {
		
		//Anonymous Inner Type
		String name="Lambda Thread";
		new Thread(() -> {
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
			
		}).start();
		System.out.println("main thread son satır");
		
		
	}
}