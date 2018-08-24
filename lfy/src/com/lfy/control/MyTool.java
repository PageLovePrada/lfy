package com.lfy.control;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import ewebeditor.admin.main_jsp;
/**
 * 
 * @author 刘峰源 工具类
 * 
 */
public class MyTool {
	/**
	 * 
	 * @param	传入	priperties Key
	 * @return	返回	priperties value
	 */
	public String readPriperties(String name) {

	    Properties properties = new Properties();
	   	// 使用InPutStream流读取properties文件
    	try {
    		BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getClass().getResource("/").getPath()+"/data.properties"));
			properties.load(bufferedReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // 获取key对应的value值
		return properties.getProperty(name);
	}
	
	public boolean appendTxt(String txtPath,String insertText) {
		try {
			/* 写入TXT文件 */
			BufferedWriter output = new BufferedWriter(new FileWriter(txtPath, true));// true,则追加写入text文本
			output.write(insertText);
			output.flush();// 把缓存区内容压入文件
			output.close();// 最后记得关闭文件
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//测试方法执行时间
	public long usertime() {
		return System.currentTimeMillis();
	}
	//时间差
	public long reduceTime(long time1,long time2) {
		return time2 - time1;
	}
	/**
	 * main方法测试
	 * @param args
	 */
	public static void main(String[] args) {
	}
}
