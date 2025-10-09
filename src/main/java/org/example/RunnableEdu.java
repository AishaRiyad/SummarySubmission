package org.example;

public class RunnableEdu {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        });

//thread.run();

        Thread lambdaThread=new Thread(()->System.out.println("Running"));
        lambdaThread.run();
    }
}

