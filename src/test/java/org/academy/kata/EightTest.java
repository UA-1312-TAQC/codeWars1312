package org.academy.kata;

import org.academy.kata.dataprovider.EightDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EightTest extends EightDataProvider {

    @Test(dataProvider = "data-Liters")
    public void testLiters(IEight eight, double in, int expected, boolean shouldThrow) {
        int actual;
        if (!shouldThrow) {
            actual = eight.liters(in);
            Assert.assertEquals(actual, expected);
        } else {
            try {
                actual = eight.liters(in);
                Assert.assertTrue(actual == expected || actual == 0 || actual == -1);
            } catch (IllegalArgumentException ex) {
                Assert.assertEquals(ex.getMessage(), String.format("Time must be between 0 and %.2f.", Integer.MAX_VALUE * 2.0));
            }
        }
    }

    @Test(dataProvider = "data-Cuboid")
    public void testGetVolumeOfCuboid(IEight eight, double length, double width, double height, double expectedVolume) {
        double actual = eight.getVolumeOfCuboid(length, width, height);
        Assert.assertEquals(actual, expectedVolume, 0.01);
    }

    @Test(dataProvider = "data-MpgToKPM")
    public void testMpgToKPM(IEight eight, float mpg, float expected) {
        float actual = eight.mpgToKPM(mpg);
        Assert.assertEquals(actual, expected, 0.001f);
    }

    @Test(dataProvider = "data-SquareOrSquareRoot")
    public void testSquareOrSquareRoot(IEight eight, int[] inputArray, int[] expected) {
        int[] actual = eight.squareOrSquareRoot(inputArray);
        Assert.assertEquals(actual, expected);
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