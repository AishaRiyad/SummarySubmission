package org.example;

public class GenaricExample {
    public static <T> void printElements(T array[]){
        for(T element:array){
            System.out.println(element);
        }
    }
    public static void main(String[] args) {
        Integer integerArray[]={1,3,2,9,11};
        String stringArray[]={"aisha","amal","tala"};
          printElements(integerArray);
          printElements(stringArray);
    }
}

