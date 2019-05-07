package com.kodilla.patterns.factory.tasks;

import org.junit.*;

public class TaskFactoryTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.\n");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\nAll tests are finished");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test nr " + testCounter + "...");
    }


    @Test
    public void testEmptyTask(){
        //Given
        TasksFactory task = new TasksFactory();

        //When
        Tasks shoppingTask = task.makeTask(TasksFactory.SHOPPING);

        //Then
        Assert.assertFalse(shoppingTask.isTaskExecuted());
        System.out.println("Is empty task executed? " + shoppingTask.isTaskExecuted());

    }

    @Test
    public void testShoppingTask(){
        //Given
        TasksFactory task = new TasksFactory();

        //When
        Tasks shoppingTask = task.makeTask(TasksFactory.SHOPPING);
        shoppingTask.executeTask();

        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Makeup shopping task", shoppingTask.getTaskName());

        System.out.println("Is shopping task executed? " + shoppingTask.isTaskExecuted());
        System.out.println(shoppingTask);

    }

    @Test
    public void testSPaintingTask(){
        //Given
        TasksFactory task = new TasksFactory();

        //When
        Tasks paintingTask = task.makeTask(TasksFactory.PAINTING);
        paintingTask.executeTask();

        //Then
        Assert.assertTrue(paintingTask.isTaskExecuted());
        Assert.assertEquals("Living room task", paintingTask.getTaskName());

        System.out.println("Is painting task executed? " + paintingTask.isTaskExecuted());
        System.out.println(paintingTask);
    }

    @Test
    public void testSDrivingTask(){
        //Given
        TasksFactory task = new TasksFactory();

        //When
        Tasks drivingTask = task.makeTask(TasksFactory.DRIVING);
        drivingTask.executeTask();

        //Then
        Assert.assertTrue(drivingTask.isTaskExecuted());
        Assert.assertEquals("Poland journey task", drivingTask.getTaskName());

        System.out.println("Is driving task executed? " + drivingTask.isTaskExecuted());
        System.out.println(drivingTask);
    }
}
