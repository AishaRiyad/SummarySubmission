package org.example;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
List<String> names= Arrays.asList("aisha","","amal","ameed","tala","malik","","shahd","","osaid");
List <String> filterNames=names.stream().filter(s->s.startsWith("a")).collect(Collectors.toList());
    filterNames.forEach(System.out::println);

    System.out.println("---------------------------------------------------");

    Random r=new Random();
    r.doubles().limit(5).forEach(System.out::println);

    System.out.println("---------------------------------------------------");

    List<Double> sumNumbers=Arrays.asList(5.5,3.0,1.1,2.4);
    List<Double> mappingNumbers=sumNumbers.stream().map(n->n+n).sorted().collect(Collectors.toList());
    mappingNumbers.forEach(n->System.out.println(n));

    System.out.println("---------------------------------------------------");

    List<Integer>numbers=Arrays.asList(5,55,555,5555,55555);
    long count=numbers.parallelStream().filter(n->n>5).count();
    System.out.println(count);

    System.out.println("---------------------------------------------------");

    List<String>words=Arrays.asList("aaa","","...","","done","Finaly");
    List<String> filterWords=words.stream().filter(w->!w.isEmpty()).collect(Collectors.toList());
        String mergedString = words.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
    filterWords.forEach(System.out::println);

        System.out.println("---------------------------------------------------");

        List statistics=Arrays.asList(10000,5,77,23,99,47,35);
        IntSummaryStatistics stats=numbers.stream().mapToInt(n->n).summaryStatistics();
        System.out.println(stats.getMax()+","+stats.getMin()+","+stats.getAverage());

    }


}
