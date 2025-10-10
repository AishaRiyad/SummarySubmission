package org.example;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;

    public Employee(int id,String name){
        this.id=id;
        this.name=name;
    }
}
