package com.lfy.python;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class io流test {
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		byte[] b = new byte[1024];

		try {
			System.out.println("开始复制..");
			in = new FileInputStream("E:/桌面/picture/--1.jpg");
			out = new FileOutputStream("E:/桌面/picture/--2.jpg");
			while (true) {
				// 进行输入操作
				int num = in.read(b, 0, b.length);
				System.out.println(num);
				if (num == -1) {
					break;
				}
				// 进行输出操作
				out.write(b, 0, b.length);
			}
			System.out.println("复制成功!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {// 释放关闭，相当于是水管子，当运水完成之后，进行拔管子操作
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
