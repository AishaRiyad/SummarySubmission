package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new FileReader("file3.txt"));
            String l;
            while((l=br.readLine())!=null){
              System.out.println(l);
            }
        }catch (IOException e){

        }
    }
}
