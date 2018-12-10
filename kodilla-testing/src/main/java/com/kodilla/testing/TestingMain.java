package com.kodilla.testing;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsernme();

        if(result.equals("theForumUser")) {
            System.out.println("test OK");
        }
        else {
            System.out.println("Error!");
        }
        System.out.println("Test - pierwszy test jednostkowy");

        int a = 5;
        int b = -189;
        Calculator resultOfCalc = new Calculator();

        if (resultOfCalc.addAToB(a,b) == a+b) {
            System.out.println("Sum test OK");
        }
        else {
            System.out.println("Error!");
        }

        if (resultOfCalc.subtractBFromA(a,b) == a-b) {
            System.out.println("Subtract test OK");
        }
        else {
            System.out.println("Error!");
        }
    }
}
