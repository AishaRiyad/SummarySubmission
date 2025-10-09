package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FirstTaskCollections {
    private static void  printPerson(List<Person> person){
        for (Person p:person){
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
    private static void printIfIncluded(List<Person> person,Decision decision){
        for(Person p:person){
            if(decision.check(p)){
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        List<Person>person= Arrays.asList(
                new Person("Aisha", "Abu Jeib", 22),
                new Person("Amal", "Aldeek", 22),
                new Person("Ameed", "Abu safieh", 22),
                new Person("Mohammad", "Shadid", 22),
                new Person("Nassar", "Harsheh", 22),
                new Person("Osamah", "Abdullah", 22),
                new Person("Ibrahim", "Asad", 22)
        );
        Collections.sort(person,new  Comparator<Person>(){
            @Override
            public int compare(Person person1,Person person2) {
                return person1.getLastName().compareTo(person2.getLastName());
            }
        });
        System.out.println("Person Full List:");
        printPerson(person);
        System.out.println("________________________________________________");
        printPersonLastNameStartWithA(person);
        System.out.println("________________________________________________");
        System.out.println("Person Start with A Full List:");
        printIfIncluded(person,new Decision(){
            @Override
            public boolean check(Person p){
                return p.getLastName().startsWith("A");
            }
        });

    }
}

@FunctionalInterface
interface Decision{
    boolean check(Person person);
}

