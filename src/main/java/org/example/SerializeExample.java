package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeExample {
    public static void main(String[] args) {
        try {
            Employee employee = new Employee(5, "Aisha");
            FileOutputStream fileOutputStream = new FileOutputStream("employee.ser");
            ObjectOutputStream out=new ObjectOutputStream(fileOutputStream);
            out.writeObject(employee);
            out.close();
            fileOutputStream.close();
            System.out.println("Object serialized");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
