package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FirstTaskLambda {
    private static void  printPerson(List<Person> person){
        for (Person p:person){
            System.out.println(p);
        }
    }
    private static void printIfIncluded(List<Person> person, Decision decision){
        for(Person p:person){
            if(decision.check(p)){
                System.out.println(p);
            }
        }
    }
    private static void printIfIncludedUsingPredicate(List<Person> person, Predicate <Person>predicate, Consumer<Person> consumer){
        for(Person p:person){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> person = Arrays.asList(
                new Person("Aisha", "Abu Jeib", 22),
                new Person("Amal", "Aldeek", 22),
                new Person("Ameed", "Abu safieh", 22),
                new Person("Mohammad", "Shadid", 22),
                new Person("Nassar", "Harsheh", 22),
                new Person("Osamah", "Abdullah", 22),
                new Person("Ibrahim", "Asad", 22),
                new Person("Gais", "Salameh", 22)
        );
        Collections.sort(person, ( person1, person2)->  person1.getLastName().compareTo(person2.getLastName()));
        System.out.println("Person Full List:");
        printIfIncludedUsingPredicate(person,p->true,p->System.out.println(p));
        System.out.println("________________________________________________");
        System.out.println("Person Start with A Full List:");
        printIfIncluded(person,(p)->p.getLastName().startsWith("A"));
        System.out.println("Person Start with S Full List:");
        printIfIncludedUsingPredicate(person,p->p.getLastName().startsWith("S"),p->System.out.println(p));
    }
}

