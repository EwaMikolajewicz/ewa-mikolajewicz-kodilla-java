package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
        OddNumbersExterminator oddExterminator = new OddNumbersExterminator();

        @BeforeClass
        public static void beforeClass(){
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
            for (int i = 0; i < 10; i++) {
                list.add(i * 2 + 1);
            }

            //When
            List<Integer> result = oddExterminator.exterminate(list);

            //Then
            Assert.assertEquals(0,  result.size());
        }
        @Test
        public void testOddNumbersExterminatorNormalList() {

            //Given
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(i * 3 + 17);
            }

            //When
            List<Integer> result = oddExterminator.exterminate(list);

            //Then
            Assert.assertNotEquals(0,  result.size());
        }
}