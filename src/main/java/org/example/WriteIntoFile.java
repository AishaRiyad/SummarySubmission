package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteIntoFile {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("secondFile.txt");
            fileWriter.write("The journy of learning was started.");
            fileWriter.close();
        }catch (IOException e){
            e.getStackTrace();
        }


    }
}
