package org.example;

import java.io.*;

public class BufferWritterEx {
    public static void main(String[] args) {
        try{
            BufferedWriter  bw=new BufferedWriter(new FileWriter("file3.txt"));
            bw.write("First Line");
            bw.newLine();
            bw.write("Next Line");
            System.out.println("Successfully written");

        }catch (IOException e){

        }
    }
}
