package org.example;

import java.util.function.Function;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
      MyThread firstThread = new MyThread();

//        Preferred way — because Java supports multiple inheritance through interfaces.
//        Also makes it easier to share the same Runnable between multiple threads.

        Thread firstThread1 = new Thread(new MyRunnable());

//        start() → creates a new thread and then calls run() internally
      firstThread.start();

      firstThread1.start();

      ThreadsTasks task1=new ThreadsTasks();
      ThreadsTasks task2=new ThreadsTasks();
      task1.setName("thread1");
      task2.setName("thread2");
      task1.start();
      task2.start();

//      method references
      Function<Integer, Integer> func = MathUtils::square;
      System.out.println(func.apply(5));
    }
}