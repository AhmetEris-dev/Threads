package com.ahmete.ThreadList;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class _02_VectorThreadliListe {
	
	Vector<Integer> list1=new Vector<>();
	Vector<Integer> list2=new Vector<>();
	
	Random random=new Random();
	
	public static void main(String[] args) {
		_02_VectorThreadliListe threadsizListe=new _02_VectorThreadliListe();
		long start = System.nanoTime();
		threadsizListe.threadIleDegerEkle();
		long end = System.nanoTime();
		System.out.println("Threadsiz liste gecen süre: "+(end-start));
		
	}
	
	public void threadIleDegerEkle(){
		Thread t1=new Thread(()->{
			listereDegerEkle();
		});
		Thread t2=new Thread(()->{
			listereDegerEkle();
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("List1 eleman sayisi: "+list1.size());
		System.out.println("List2 eleman sayisi: "+list2.size());
		
		
	}
	
	public synchronized void listereDegerEkle(){
		for (int i = 0; i <5000 ; i++) {
		list1eDegerEkle();
		list2eDegerEkle();
		}
		
	}
	
	// synchronized eleman sayısını garanti altına almasını sağlar
	// eğer collection yapımız thread safe olan vector olursa
	// burada synchronized keywordü kullanmasak da eleman sayısı garanti altındadır
	public  void list1eDegerEkle(){
		list1.add(random.nextInt(0,101) );
	}
	
	public void list2eDegerEkle(){
		list2.add(random.nextInt(0,101) );
	}
}