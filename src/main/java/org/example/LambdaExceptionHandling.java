package org.example;

import java.util.function.BiConsumer;

public class LambdaExceptionHandling {

    private static void process(int array[], int key, BiConsumer<Integer, Integer> biConsumer) {
        for (int k : array) {
            biConsumer.accept(k, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
        return biConsumer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int key = 1;
        BiConsumer<Integer, Integer> consumer = wrapperLambda((a, b) ->
        {
            try {
                System.out.println(a / b);
            } catch (ArithmeticException ae) {
                System.out.println(ae.getMessage());
            }
        });
        process(numbers, key, consumer);

    }
}