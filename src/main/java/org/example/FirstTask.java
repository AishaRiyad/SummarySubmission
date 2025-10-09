package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FirstTask {
    private static void printPerson( List<Person> person){
        for(Person p:person){
            System.out.println(p);
        }
    }
    private static void printPersonLastNameStartWithA( List<Person> person){
        for(Person p:person){
            if(p.getLastName().startsWith("A")){
                System.out.println(p);
            }
        }
    }
    public static void main(String[] args) {
        List<Person>person=Arrays.asList(
                new Person("Aisha", "Abu Jeib", 22),
                new Person("Amal", "Aldeek", 22),
                new Person("Ameed", "Abu safieh", 22),
                new Person("Mohammad", "Shadid", 22),
                new Person("Nassar", "Harsheh", 22),
                new Person("Osamah", "Abdullah", 22),
                new Person("Ibrahim", "Asad", 22)
        );
        person.sort(Comparator.comparing(Person::getLastName));
        printPerson(person);
        System.out.println("--------------------------------------");
        printPersonLastNameStartWithA(person);


    }

}

