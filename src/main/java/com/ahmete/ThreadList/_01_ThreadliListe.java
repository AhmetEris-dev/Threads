package com.ahmete.ThreadList;

import java.util.ArrayList;
import java.util.Random;

public class _01_ThreadliListe {
	
	ArrayList<Integer> list1=new ArrayList<>();
	ArrayList<Integer> list2=new ArrayList<>();
	
	Random random=new Random();
	
	public static void main(String[] args) {
		_01_ThreadliListe threadsizListe=new _01_ThreadliListe();
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
		for (int i = 0; i <10000 ; i++) {
		list1eDegerEkle();
		list2eDegerEkle();
		}
		
	}
	
	// synchronized eleman sayısını garanti altına almasını sağlar
	public synchronized void list1eDegerEkle(){
		list1.add(random.nextInt(0,101) );
	}
	
	public synchronized void list2eDegerEkle(){
		list2.add(random.nextInt(0,101) );
	}
}