package com.ahmete.Downloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloaderMultiThread {
	public static void main(String[] args) {
		int threadSayisi=50;
		
		ExecutorService executorService= Executors.newFixedThreadPool(threadSayisi);
		
		executorService.submit(()->{
			// doyaIndir
			// dosyayaYaz
		});
	}
}