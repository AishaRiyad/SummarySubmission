package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {
    public static void main(String[] args) {
      String s="new Text";
      try{
          FileOutputStream out=new FileOutputStream("file2.txt");
          out.write(s.getBytes());
          System.out.println("syccessfully written");

      }catch (IOException e){
        e.printStackTrace();
      }
    }
}
