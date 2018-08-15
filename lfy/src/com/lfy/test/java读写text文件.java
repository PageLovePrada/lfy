package com.lfy.test;


import java.io.File;  
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileWriter;  
public class java读写text文件 {

      public static void insertJson(String key,String value){
    	  
          try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  

      		String path = new File("").getAbsolutePath();
              /* 读入TXT文件 */  
              String pathname = path+"/WebRoot/dataSource/King2222.map"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
              File filename = new File(pathname); // 要读取以上路径的input。txt文件  
              InputStreamReader reader = new InputStreamReader(  
                      new FileInputStream(filename)); // 建立一个输入流对象reader  
              BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
              String line = ""; 
              int length = 1;
              String endLine = "";
              line = br.readLine();
              if(line != null){
              	System.out.println(length+line);
              }
              while (line != null) {  
              	// 一次读入一行数据  
                  line = br.readLine(); 
              	if(line != null){
              		length++;
                      System.out.println(length+line);
              	}
              }  
              System.out.println(length);
    
              /* 写入Txt文件 */  
//              File writename = new File(".\\result\\en\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件  
//              writename.createNewFile(); // 创建新文件  
//              BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
//              out.write("我会写入文件啦\r\n"); // \r\n即为换行  
//              out.flush(); // 把缓存区内容压入文件  
//              out.close(); // 最后记得关闭文件  
    
          } catch (Exception e) {  
              e.printStackTrace();  
          }  
      }
      public  static void main(String args[]) { 
    	  insertJson("","");
    	  
        }  

}
