package com.ahmete.Downloader;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloaderTekThread {
	public static void main(String[] args) {
		String indilerecekDosyaAdresi="https://www.cs.cmu.edu/afs/cs.cmu.edu/user/gchen/www/download/java/LearnJava.pdf";
//		String indilerecekDosyaAdresi="https://fotolifeakademi.com/fotograf-cekim-teknikleri/manzara-fotografi-cekmek";
		
		String kaydedilecekDosyaAdi="LearnJava.pdf";
		Long toplamBoyut=dosyaBoyutBul(indilerecekDosyaAdresi);
		System.out.println("İndirilecek dosya botuyu: "+toplamBoyut);
		
		long start = System.currentTimeMillis();
		FileDownloaderThread downloaderThread=new FileDownloaderThread(indilerecekDosyaAdresi,kaydedilecekDosyaAdi);
		downloaderThread.start();
		
		while (downloaderThread.isAlive()){ //arka planda iş yapıyor mu .isAlive
			try {
				Thread.sleep(1000);
				System.out.println("inen dosya boyutu: %"+downloaderThread.inenDosyaBoyutu*100/toplamBoyut);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			downloaderThread.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		Long end=System.currentTimeMillis();
		System.out.println("Tek thread ile download için gecen süre: "+(end-start)+" ms: ");
	}
	
	public static Long dosyaBoyutBul(String indilerecekDosyaAdresi){
		long contentLengthLong=0;
		try {
			URL url=new URL(indilerecekDosyaAdresi);
			HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("HEAD");
			String contentType = httpURLConnection.getContentType();
			System.out.println("Content-Type: "+contentType);
			contentLengthLong=  httpURLConnection.getContentLengthLong();
		
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return contentLengthLong;
	}
}

class FileDownloaderThread extends Thread {
	
	int inenDosyaBoyutu=0;
	String filename;
	String url;
	
	public FileDownloaderThread(String url, String filename) {
		this.url = url;
		this.filename = filename;
	}
	
	@Override
	public void run() {
		super.run();
		try (BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream())) {
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			byte[] buffer = new byte[1024];
			int readedByte;
			while ((readedByte = inputStream.read(buffer, 0, 1024)) != -1){
				fileOutputStream.write(buffer, 0, readedByte);
				inenDosyaBoyutu+=readedByte;
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}