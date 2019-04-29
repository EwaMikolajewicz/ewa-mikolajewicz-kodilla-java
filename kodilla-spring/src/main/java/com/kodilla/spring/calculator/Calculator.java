package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

    @Autowired
    private Display display;

    public double add(double a, double b) {
        System.out.println("addValue: ");
        display.displayValue(a + b);
        return a + b;
    }

    public double sub(double a, double b) {
        System.out.println("subValue: ");
        display.displayValue(a - b);
        return a - b;
    }

    public double mul(double a, double b) {
        System.out.println("mulValue: ");
        display.displayValue(a * b);
        return a * b;
    }

    public double div(double a, double b) throws ArithmeticException {
        System.out.println("divValue: ");

        if (b == 0) {
            throw new ArithmeticException();
        }
        display.displayValue(a / b);
        return a / b;
    }
}

