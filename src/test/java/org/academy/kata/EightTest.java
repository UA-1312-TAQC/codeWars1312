package org.academy.kata;

import org.academy.kata.dataprovider.EightDataProvider;
import org.academy.kata.implementation.nestea4.Eight;
import org.academy.utils.Author;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EightTest extends EightDataProvider {

    private static IEight implementation;
    @BeforeTest
    public void setImplementation(){
        int authorId = 1; //Move to parameters
        try {
            implementation = Author.getAuthorById(authorId).getEight();
        }catch(NullPointerException ex){
            throw new RuntimeException("The kata5 implementation for author with id" + authorId +
                    " not found");
        }
    }

    @Test(dataProvider = "data-Liters")
    public void testLiters(IEight eight, double in, int expected) {
        int actual = eight.liters(in);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testLiters2() {
        IEight eight = new Eight();
        int actual = eight.liters(55);
        int expected = 27;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetVolumeOfCuboid() {
    }

    @Test
    public void testMpgToKPM() {
    }

    @Test
    public void testSquareOrSquareRoot() {
    }

    @Test
    public void testCountPositivesSumNegatives() {
    }

    @Test
    public void testStringToNumber() {
    }

    @Test(dataProvider = "twoDecimalPlacesData")
    public void testTwoDecimalPlaces(double expected, double data, double delta) {
        double actual = implementation.TwoDecimalPlaces(data);
        Assert.assertEquals(actual, expected, delta);
    }

    @Test
    public void testDivisibleBy() {
    }

    @Test
    public void testAm_i_wilson() {
    }
}