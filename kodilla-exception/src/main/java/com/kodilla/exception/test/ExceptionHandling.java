package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {

            secondChallenge.probablyIWillThrowException(0.0, 1.5);

        } catch (Exception e) {

            System.out.println("Problem with numbers... " + e);

        } finally {

            System.out.println("I'm still here :-)");

        }
    }
}
