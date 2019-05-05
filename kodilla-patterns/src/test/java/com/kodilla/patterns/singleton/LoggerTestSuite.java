package com.kodilla.patterns.singleton;

import org.junit.*;

public class LoggerTestSuite {
    private static int testCounter = 0;
    static Logger logger;

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

        //dot pkt 1 zadania 15.1
    @Test
    public void testGetTheLastLog(){
        //Given
        logger = new Logger("Log number 1");
        logger.toLog("It is the last log pkt 1");
        //When
        String theLastLog = logger.getLastLog();
        System.out.println("Last log nr 1: " + theLastLog);

        //Then
        Assert.assertEquals("It is the last log pkt 1", theLastLog);
    }

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("It is the last log pkt 2");
        //When
        String lastLog = Logger.getInstance().getLastLog();
        System.out.println("Last log: " + lastLog);

        //Then
        Assert.assertEquals("It is the last log pkt 2", lastLog);
    }
}
