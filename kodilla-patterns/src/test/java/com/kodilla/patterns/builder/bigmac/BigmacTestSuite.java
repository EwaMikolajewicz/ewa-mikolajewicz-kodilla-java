package com.kodilla.patterns.builder.bigmac;

import org.junit.*;

public class BigmacTestSuite {

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


    @Test
    public void testBicmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("with sesame")
                .sauce("Barbeque")
                .ingredient(Bigmac.Ingredients.mushrooms)
                .ingredient(Bigmac.Ingredients.onion)
                .burgers(3)
                .ingredient(Bigmac.Ingredients.cucumber)
                .ingredient(Bigmac.Ingredients.salad)
                .ingredient(Bigmac.Ingredients.bacon)
                .ingredient(Bigmac.Ingredients.shrimp)
                .ingredient(Bigmac.Ingredients.mushrooms)
                .ingredient(Bigmac.Ingredients.chilli_peppers)
                .ingredient(Bigmac.Ingredients.cheese)
                .build();

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        String kindOfSauce = bigmac.getSauce();

        //Then
        Assert.assertEquals(8, howManyIngredients);
        Assert.assertEquals("Barbeque", kindOfSauce);
        System.out.println("Number of ingredients: " + howManyIngredients + ": " + bigmac.getIngredients());
        System.out.println("Sauce: " + bigmac.getSauce());
    }

    @Test
    public void testIfAreAnyIngredients() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("without sesame")
                .sauce("Barbeque")
                .burgers(5)
                .build();

        //When
        boolean areAnyIngredients = bigmac.getIngredients().isEmpty();

        //Then
        Assert.assertTrue(areAnyIngredients);
        System.out.println("There are no ingredients? " + areAnyIngredients + ": " + bigmac.getIngredients());
    }

    @Test
    public void testNullParameter() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("without sesame")
                .burgers(2)
                .ingredient(Bigmac.Ingredients.mushrooms)
                .ingredient(Bigmac.Ingredients.onion)
                .build();

        //When
        String result = bigmac.getSauce();

        //Then
        Assert.assertNull(result);
        System.out.println("Chosen sauce: " + bigmac.getSauce());
    }
}
