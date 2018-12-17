package com.lfy.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("post");
	}
	static int time = 1;
	static void 钱晓蕾(){
		if(time < 4){
		new Thread(){
            public void run(){
               try {
            	   switch (time) {
						case 1:
			        		   System.out.println("运势计算中....");
			                   Thread.sleep(2000);
			                   time=2;
			               		钱晓蕾();
							break;
						case 2:
			        		   System.out.println("你这有点难啊....");
			                   Thread.sleep(2000);
			                   time=3;
			               		钱晓蕾();
							break;
						case 3:
			        		   System.out.println("这坎也忒多了....");
			                   Thread.sleep(2000);
			                   time=4;
			               		钱晓蕾();
							break;
		
						default:
		               		钱晓蕾();
							break;
						}
               } catch (InterruptedException e) { }
            }
         }.start();
		}else{
		new Thread(){
            public void run(){
               try {
                  Thread.sleep(500);
          		  System.out.println("大傻叉");
          		  大傻叉();
               } catch (InterruptedException e) { }
            }
         }.start();
		}
	}
	static void 大傻叉(){
		new Thread(){
            public void run(){
               try {
            	   	Thread.sleep(500);
          			System.out.println("钱晓蕾");
          			钱晓蕾();
               } catch (InterruptedException e) { }
            }
         }.start();
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入姓名测运势!请输入姓名:");
        while(true){
        	String str = scan.next();
    		if(str.equals("刘峰源")){
    			System.out.println("真帅!!!!!");
    		}
			if(str.equals("钱晓蕾")){
				钱晓蕾();
			}
        }
	}

}
//刘峰源
//钱晓蕾