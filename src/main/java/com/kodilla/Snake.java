package com.kodilla;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snake {
    public static void main(String[] args) {

        String aLetters = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        ArrayDeque<String> aSnakes = new ArrayDeque<>();

        Random lengthGenerator = new Random();

        System.out.println("Part 1: Creating 50 \"a\" letters snakes...");

        for (int i = 0; i < 50; i++) {
            aSnakes.push(aLetters.substring((lengthGenerator.nextInt(50)+1)));
        }
        for (String snakeA : aSnakes) {
            System.out.println(snakeA);

        }
        System.out.println("Done! " + aSnakes.size() + " was created.");

        System.out.println("\nPart 2: Dividing the ArrayDeque of \"a\" letters snakes into two ArrayLists ...");

        List<String> evenSnake = new ArrayList<>();
        List<String> oddSnake = new ArrayList<>();

        while (aSnakes.size() > 0) {
            String snakeA = aSnakes.poll();
                if (snakeA.length() % 2 == 0) {
                    evenSnake.add(snakeA);
                } else {
                    oddSnake.add(snakeA);
                }

        }
        System.out.println("\nEven length snakes of \"a\": ");
        for (String even : evenSnake) {
            System.out.println(even + ", length: " + even.length());
        }
        System.out.println("Done! " + evenSnake.size() + " of even \"a\" letters snakes was found ");

        System.out.println("\nOdd length Snake of \"a\": ");
        for (String odd : oddSnake) {
            System.out.println(odd + ", length: " + odd.length());
        }
        System.out.println("Done! " + oddSnake.size() + " of odd \"a\" letters snakes was found ");
    }
}
