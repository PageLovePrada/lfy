package com.lfy.test;

import ewebeditor.admin.main_jsp;

public class ThreadTest2 implements Runnable {
	
	public void run(){
		System.out.println("线程2 启动");
		
	}
	
	
	public static void main(String[] args) {
		ThreadTest2 t1 = new ThreadTest2();
		ThreadTest2 t2 = new ThreadTest2();
		ThreadTest2 t3 = new ThreadTest2();
		t1.run();
		t2.run();
		t3.run();
	}

}
