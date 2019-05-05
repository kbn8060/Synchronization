package com.app;

class Table {
	synchronized void pintTable(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class MyThread1 extends Thread {
	Table t;

	MyThread1(Table t) {
		this.t = t;
	}

	public void run() {
		t.pintTable(100);
	}
}

class MyThread2 extends Thread {
	Table t;

	MyThread2(Table t) {
		t.pintTable(5);

	}
}

public class Synchronization {

	public static void main(String[] args) {
		Table t = new Table();
		MyThread1 mt1 = new MyThread1(t);
		MyThread2 mt2 = new MyThread2(t);
		mt1.start();
		mt2.start();
	}
}
