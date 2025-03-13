package org.example;

import java.io.IOException;
import java.net.Socket;


public class Task5 implements Task {
	private int startPort;
	private int endPort;
	private boolean running;
	
	public Task5(int startPort, int endPort) {
		this.startPort = startPort;
		this.endPort = endPort;
	}
	
	@Override
	public void start() {
		running = true;
		
		Thread scannerThread = new Thread(() -> {
			for (int port = startPort; port <= endPort; port++) {
				if (!running) {
					System.out.println("СТОП");
					break;
				}
				try (Socket socket = new Socket("localhost", port)) {
					System.out.println("Порт " + port + " открыт");
				} catch (IOException e) {
					
				}
			}
		});
		
		scannerThread.start();
	}
	
	@Override
	public void stop() {
		running = false;
	}
	
	public static void main(String[] args) {
		Task5 portScanner = new Task5(1, 1024);
		portScanner.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Exception: " + e);
		}
		
		portScanner.stop();
	}
	
}
