package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadImage {
    public static void main(String[] args) {
       try{
           FileInputStream in=new FileInputStream("image.jpg");
           FileOutputStream out=new FileOutputStream("copyImage.jpg");
           int i;
           while((i=in.read())!=-1){
               out.write(i);
           }
           System.out.println("image copied successfully");
       }catch (IOException e){
         e.printStackTrace();
       }
    }
}
