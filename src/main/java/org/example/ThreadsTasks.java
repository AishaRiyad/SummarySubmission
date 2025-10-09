package org.example;

public class ThreadsTasks extends Thread{
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Count: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
