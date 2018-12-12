package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
        @BeforeClass
        public static void beforeClas(){
            System.out.println("Test Suite: begin");
        }

        @AfterClass
        public static void afterClass(){
            System.out.println("Test Suite: end");
        }

        @Before
        public void before(){
            System.out.println("Test Case: begin");
        }

        @After
        public void after(){
            System.out.println("Test Case: end");
        }

        @Test
        public void testOddNumbersExterminatorEmptyList() {
            //Given
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++)
                list.add(i * 2 + 1);
            OddNumbersExterminator oddExterminator = new OddNumbersExterminator();
            oddExterminator.exterminate(list);
            //When
            oddExterminator.exterminate(list).size();
            System.out.println("Testing empty list...");
            //Then
            Assert.assertEquals(0,  oddExterminator.exterminate(list).size());
        }
        @Test
        public void testOddNumbersExterminatorNormalList() {
             //Given
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++)
                list.add(i * 3 + 17);
            OddNumbersExterminator oddExterminator = new OddNumbersExterminator();
            oddExterminator.exterminate(list);
            //When
            oddExterminator.exterminate(list).size();
            System.out.println("Testing normal list...");
            //Then
            Assert.assertNotEquals(0,  oddExterminator.exterminate(list).size());
        }
}
