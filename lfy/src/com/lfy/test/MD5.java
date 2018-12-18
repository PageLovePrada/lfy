package com.lfy.test;  
  
import java.security.MessageDigest;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
public class MD5 {  
  
    public static List<Map<String, String>> lists = new ArrayList<Map<String, String>>();  
    public static String[] chars = "0123456789abcdefghijklmnopkrstuvwxyzABCDEFGHIJKLMNOPKRSTUVWXYZ!@#$%^&*()_+-=`~?><,.".split("");  
    public static int size = chars.length;  
      
    public static void main(String[] args){  
        generatePass(4);  
    }  
      
    public static void generatePass(int len){  
        Map<String, String> item = new HashMap<String, String>();  
        double count = 0;  
        for(double index = 0; index < Math.pow(chars.length, len); index++){  
            String pass = getNumPass(index);  
            //item.put("pass", pass);  
            //item.put("md5", md5(pass));  
            count++;  
            synchronized(lists){  
                //lists.add(item);  
                  
            }  
        }  
        System.out.println(count);  
    }  
      
    public static String getNumPass(double num){  
          
        int len = 1;  
        int pos = 0;  
        if(num % size == 0){  
            pos = 1;  
        }  
          
        while(Math.pow(size, len) < num){  
            len += 1;  
        }  
          
        len += pos;  
  
          
          
        int[] arr = new int[len];  
          
        int count =  len - 1;  
        while(num >= size){  
            arr[count] = (int) (num % size);  
            num = Math.floor(num/size);  
            count--;  
        }  
          
          
        arr[count] = (int)num;  
          
        String result = "";  
        for(int i = 0; i < len; i++){  
            result += chars[arr[i]];  
        }  
          
        return result;  
    }  
      
    public static String md5(String s){  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
        try {  
            byte[] btInput = s.getBytes();  
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }         
    }  
      
    public static class SavePass extends Thread{  
        public void run(){  
            while(true){  
                  
                while(MD5.lists.size() > 0){  
                    Map<String, String> item = MD5.lists.get(0);  
                    synchronized(MD5.lists){  
                        MD5.lists.remove(0);  
                    }  
                      
                    System.out.println(item.get("md5") + "=" + item.get("pass"));  
                }  
            }  
        }  
    }  
}  