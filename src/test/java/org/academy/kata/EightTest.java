package org.academy.kata;

import org.academy.kata.dataprovider.EightDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EightTest extends EightDataProvider {

    @Test(dataProvider = "data-Liters")
    public void testLiters(IEight eight, double in, int expected) {
        int actual = eight.liters(in);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-Liters_neg")
    public void testLiters_neg(IEight eight, double in, int expected) {
        try {
            int actual = eight.liters(in);
            Assert.assertTrue(actual == expected || actual == 0 || actual == -1);
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), String.format("Time must be between 0 and %.2f.", Integer.MAX_VALUE * 2.0));
        }
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

    @Test
    public void testTwoDecimalPlaces() {
    }

    @Test
    public void testDivisibleBy() {
    }

    @Test
    public void testAm_i_wilson() {
    }
}