package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void checkedExceptionWithThrows()throws FileNotFoundException {
       File file=new File("notExistingFile.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
    }

    public static void checkedExceptionWithTryCatch(){
        File file=new File("not_existing_file.txt");
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void divideByZero(int numerator,int denominator) {
        try {
            int result = numerator / denominator;
            System.out.println(result);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
      divideByZero(5,0);
    }
}