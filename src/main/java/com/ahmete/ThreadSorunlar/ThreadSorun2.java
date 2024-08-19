package com.ahmete.ThreadSorunlar;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSorun2 {
	//AtomicInteger değişkenleri multi-thread uygulamalarda
	//ve lambda exp içinde locak değişken gereken yerlerde kullanabilirsiniz.
	public static void main(String[] args) {
//		int i=1;
		AtomicInteger i=new AtomicInteger(1);
		List<String > isimler=List.of("Özkan","Ahmet","Emine","Alex","Muzaffer","Emirhan");
		isimler.forEach(isim->{
			System.out.println(i+". kişi= "+isim);
			i.getAndIncrement();
		});
	}
}