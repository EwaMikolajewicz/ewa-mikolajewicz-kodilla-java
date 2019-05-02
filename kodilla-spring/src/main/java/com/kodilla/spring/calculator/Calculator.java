package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Calculator {

    @Autowired
    private Display display;

    public double add(double a, double b) {
        System.out.println("Addition: ");
        display.displayValue(a + b);
        return a + b;
    }

    public double sub(double a, double b) {
        System.out.println("Subtraction: ");
        display.displayValue(a - b);
        return a - b;
    }

    public double mul(double a, double b) {
        System.out.println("Multiplication: ");
        display.displayValue(a * b);
        return a * b;
    }

    public double div(double a, double b) throws ArithmeticException {
        System.out.println("Division: ");

        if (b == 0) {
            throw new ArithmeticException();
        }
        display.displayValue(a / b);
        return a / b;
    }

    public List<Double>  operation(double a, double b) {
        List<Double> theList = new ArrayList<>();

        theList.add(add(a, b));
        theList.add(sub(a, b));
        theList.add(mul(a, b));
        theList.add(div(a, b));

        return theList;
    }
}


