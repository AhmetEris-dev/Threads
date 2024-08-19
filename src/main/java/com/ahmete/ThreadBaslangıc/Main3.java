package com.ahmete.ThreadBaslangıc;

public class Main3 {
	public static void main(String[] args) {
		MyThread3 myThread3=new MyThread3("myThread3");
		
//		myThread3.run();// !!! run metodu ile cagırırsak Thread mantıgında calışmaz!
//		myThread3.start() // !!! extends thread yapmadıgımız için start metodu gelmez!
		Thread thread3=new Thread(myThread3);
		thread3.start();
		System.out.println("main thread son satır");
	}
}