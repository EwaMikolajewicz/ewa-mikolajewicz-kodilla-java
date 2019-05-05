package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

        //dot pkt 1 zadania 15.1
//        @Before
//        public void before(){
//            System.out.println("Testy do pkt 1 zadania 15.1: ");
//        }
//    private static Logger logger;
//
//    @BeforeClass
//    public static void createLog(){
//        logger = new Logger();
//        logger.log("It is the last log");
//    }
//
//    @Test
//    public void testGetLastLog(){
//        //Given
//        //When
//        String lastLog = logger.getLastLog();
//        System.out.println("Last log: " + lastLog);
//
//        //Then
//        Assert.assertEquals("It is the last log", lastLog);
//    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Testy do pkt 2-4 zadania 15.1: ");
    }

    @Before
    public void createLog() {
        Logger.getInstance().log("It is the last log");
    }

    @Test
    public void testGetLastLog() {
        //Given
        //When
        String lastLog = Logger.getInstance().getLastLog();
        System.out.println("Last log: " + lastLog);

        //Then
        Assert.assertEquals("It is the last log", lastLog);
    }
}
