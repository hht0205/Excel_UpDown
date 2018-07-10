package com.it.test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
public class txtToList {
 public static void main(String[] args) {
  
   txtFileTest();
  }
  
 
 public static void txtFileTest()
 {
     List<String> strList = new ArrayList<String>();
     try 
     {
         BufferedReader bufReader = new BufferedReader(new FileReader("F:\\3.txt"));
         while(true)
         {
             String lineStr = bufReader.readLine();
             if(lineStr != null)
             {
                 strList.add(lineStr);
             }
             else
             {
                 break;
             }
         }
         bufReader.close();
     }
     catch (IOException e) 
     {
         e.printStackTrace();
     }
     //�����ȡ�Ľ��
     for (int i = 0; i < strList.size(); i++) {
         System.out.println(strList.get(i));
     }
 }
 
 
 
 
 public static List<String> txtFileTest(Reader file){
     List<String> list = new ArrayList<String>();
     try 
     {
//         BufferedReader bufReader = new BufferedReader(new FileReader("F:\\3.txt"));
         BufferedReader bufReader = new BufferedReader(file);
         while(true)
         {
             String lineStr = bufReader.readLine();
             if(lineStr != null)
             {
                 list.add(lineStr);
             }
             else
             {
                 break;
             }
         }
         bufReader.close();
     }
     catch (IOException e) 
     {
         e.printStackTrace();
     }
//     //�����ȡ�Ľ��
//     for (int i = 0; i < list.size(); i++) {
//         System.out.println(list.get(i));
//     }
     return  list;
 }
}