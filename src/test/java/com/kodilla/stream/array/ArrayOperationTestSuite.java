package com.kodilla.stream.array;

import org.junit.*;

public class ArrayOperationTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.\n");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\nAll tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter + "...");
    }

    @Test
    public void testGetAverageWith0Numbers(){
        //Given
        int [] numbers = new int[0];

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(0, result,0.001);
        Assert.assertEquals(0, numbers.length);
    }

    @Test
    public void testGetAverageWith0(){
        //Given
        int [] numbers = new int[]{5,6,7,8,9,0};

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(5.8333, result,0.0001);
        Assert.assertEquals(6, numbers.length);
        Assert.assertEquals(7,numbers[2]);
    }

    @Test
    public void testGetAverage(){
        //Given
        int [] numbers = new int[]{5,6,7,8,9};

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(7.0, result,0.001);
        Assert.assertEquals(5, numbers.length);
        Assert.assertEquals(9,numbers[4]);
    }
}
