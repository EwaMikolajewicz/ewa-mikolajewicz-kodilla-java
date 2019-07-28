package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    private static int testCounter = 0;

    @Before
    public void beforeTest(){
        testCounter++;
        System.out.println("\nTest nr: " + testCounter);
    }

    @Test
    public void addTest() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator result = context.getBean(Calculator.class);

        //When
        double resultAdd = result.add(3.5, 18.3);

        //Then
        Assert.assertEquals(21.8, resultAdd,0);
    }

    @Test
    public void subTest() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator result = context.getBean(Calculator.class);

        //When
        double resultSub = result.sub(3.5, 18.3);

        //Then
        Assert.assertEquals(-14.8, resultSub,0);
    }

    @Test
    public void mulTest() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator result = context.getBean(Calculator.class);

        //When
        double resultMul = result.mul(3.5, 18.3);

        //Then
        Assert.assertEquals(64.05, resultMul,0);
    }

    @Test
    public void divTest() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator result = context.getBean(Calculator.class);

        //When
        double resultDiv = result.div(3.5, 18.3);

        //Then
        Assert.assertEquals(0.1912568306010929, resultDiv,0);
    }

    @Test
    public void testCalc(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator result = context.getBean(Calculator.class);

        //When
       List<Double> listOfResult = result.operation(3.5, 18.3);

        //Then
        Assert.assertTrue(listOfResult.get(0)==21.8);
        Assert.assertTrue(listOfResult.get(1)==-14.8);
        Assert.assertTrue(listOfResult.get(2)==64.05);
        Assert.assertTrue(listOfResult.get(3)==0.1912568306010929);

    }

}