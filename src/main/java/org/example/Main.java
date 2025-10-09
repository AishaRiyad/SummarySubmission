package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       Greeter greeter=new Greeter();
       Greeting helloGreeting=new HelloGreeting();
       greeter.greet(helloGreeting);
        Greeting MyLambda=()->System.out.println("Hi Training");
        helloGreeting.perform();
        AddFun addFun=(int x, int y)->x+y;

        Greeting innerClassGreeting=new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hi Training");
            }
        };
        greeter.greet(()->System.out.println("Hi Training"));
        greeter.greet(MyLambda);
        greeter.greet(innerClassGreeting);


    }

}
 interface Lambda{
    void fun();
 }

interface AddFun{
    int add(int x,int y);
}