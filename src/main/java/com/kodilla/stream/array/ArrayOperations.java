package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        if (numbers.length == 0) {
            System.out.println("Array is empty.");
            return 0;
        } else {
            System.out.println("Average of numbers: ");
            IntStream.range(0, numbers.length)
                    .map(n -> numbers[n])
                    .forEach(System.out::println);

            double average = IntStream.range(0, numbers.length)
                    .map(n -> numbers[n])
                    .average().getAsDouble();
            return average;
        }
    }
}
