package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
      File file2=new File("secondFile.txt");
      try{
          if (file2.exists()) {
              System.out.println("File name: " + file2.getName());
              System.out.println("Absolute path: " + file2.getAbsolutePath());
              System.out.println("Writeable: " + file2.canWrite());
              System.out.println("Readable " + file2.canRead());
              System.out.println("File size in bytes " + file2.length());
          } else {
              System.out.println("The file does not exist.");
          }
          Scanner reader=new Scanner(file2);
          while (reader.hasNextLine()){
              String fileData=reader.nextLine();
              System.out.println(fileData);
          }
      }catch (IOException e){
          e.getStackTrace();
      }
    }
}
