package com.kodilla.spring.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    private static int testCounter = 0;

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator result = context.getBean(Calculator.class);

        //When
        result.add(3.5, 18.3);
        result.sub(3.5, 18.3);
        result.mul(3.5, 18.3);
        result.div(3.5, 18.3);

        //Then
        //do nothing;
    }

    @Before
    public void beforeTest(){
        testCounter++;
        System.out.println("\nTest nr: " + testCounter);
    }
    @Test
    public void testDivZero() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator result = context.getBean(Calculator.class);

        //When
        try {
            double value = result.div(3.5, 0);
            System.out.println(value);

        } catch (ArithmeticException e) {

            System.out.println(e + ". Error!!! Choose divider <> 0 !!!");
        }

        //Then
        //do nothing
    }
}
