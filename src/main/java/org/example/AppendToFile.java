package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile {
    public static void main(String[] args) {
       try{
           FileWriter fileWriter=new FileWriter("secondFile.txt",true);
           fileWriter.write("\nText Appended");
           System.out.println("Successfully appended to the file.");
       }catch (IOException e){
           e.getStackTrace();
       }


    }
}
