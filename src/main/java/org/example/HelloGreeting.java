package org.example;

public class HelloGreeting implements Greeting {
    @Override
    public void perform() {
        System.out.println("Hello World");
    }
}
