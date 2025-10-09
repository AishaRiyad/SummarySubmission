package org.example;

public class TypeInfernceExample {
    public static void main(String[] args) {
//        StringLength lambda=s->s.length();
//       System.out.println( lambda.getLength("Aisha"));
        printLength(s->s.length());
    }
    public static void printLength(StringLength l){
System.out.println(l.getLength("Aisha Abu Jeib"));
    }

    interface StringLength{
        int getLength(String s);


    }
}
