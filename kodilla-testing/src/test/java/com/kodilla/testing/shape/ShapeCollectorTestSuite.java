package com.kodilla.testing.shape;

import org.junit.*;

import java.util.List;

public class ShapeCollectorTestSuite {
    ShapeCollector shapeCollector = new ShapeCollector();
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    //Test1: sprawdzający, czy po dodaniu figury liczba figur wynosi 1
    @Test
    public void testAddFigure() {
        //Given
        Shape theShape = new Triangle(3, 4);

        //When
        shapeCollector.addFigure(theShape);

        //Then
        Assert.assertEquals(1, shapeCollector.getFiguresQuantity());
    }

    //Test2: sprawdzający, czy próba usunięcia nieistniejącej figury skończy się zwróceniem false
    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        Shape theShape = new Triangle(3, 4);

        //When
        boolean result = shapeCollector.removeFigure(theShape);

        //Then
        Assert.assertFalse(result);
    }

    //Test 3: sprawdzający, czy udało się usunąć wybraną figurę z klasy
    @Test
    public void testRemoveFigure() {
        //Given
        Shape theShape = new Triangle(3, 4);
        shapeCollector.addFigure(theShape);

        //When
        boolean result = shapeCollector.removeFigure(theShape);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFiguresQuantity());
    }

    //Test4: sprawdzający, czy pobrana figura z klasy ShapeCollector jest taka sama jak figura wstawiana do klasy
    @Test
    public void testGetFigure() {
        //Given
        Shape theShape = new Triangle(3, 4);
        shapeCollector.addFigure(theShape);

        //When
        Shape retrievedFigure = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(theShape, retrievedFigure);
    }

    //Test5: sprawdzający, czy liczba dodanych figur wynosi 3 i czy lista zawiera wstawione figury
    @Test
    public void testShowFigures() {
        //Given
        Shape triangle1 = new Triangle(3, 4);
        Shape triangle2 = new Triangle(2, 8.5);
        Shape circle = new Circle(2);

        shapeCollector.addFigure(triangle1);
        shapeCollector.addFigure(triangle2);
        shapeCollector.addFigure(circle);

        //When
        List<Shape> listOfShapes = shapeCollector.showFigures();

        //Then
        Assert.assertEquals(3, listOfShapes.size());
        Assert.assertTrue(listOfShapes.contains(triangle1));
        Assert.assertTrue(listOfShapes.contains(triangle2));
        Assert.assertTrue(listOfShapes.contains(circle));
    }
    //Test6: sprawdzający, czy dodane figury są takie same
    @Test
    public void testAddedFiguresAreTheSame() {
        //Given
        Shape theShape1 = new Circle(3);
        Shape theShape2 = new Circle(3);

        //When
        shapeCollector.addFigure(theShape1);
        shapeCollector.addFigure(theShape2);

        //Then
       Assert.assertEquals(theShape1, theShape2);
    }
}
