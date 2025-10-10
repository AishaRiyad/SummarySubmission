package org.example;

import java.io.*;

public class DeserializeExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("employee.ser");
            ObjectInputStream in=new ObjectInputStream(fileInputStream);
            Employee employee=(Employee) in.readObject();
            in.close();
            fileInputStream.close();
            System.out.println("Object Deserialized");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
