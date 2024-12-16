package org.academy.kata;

import org.academy.kata.dataprovider.EightDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EightTest extends EightDataProvider {

    @Test(dataProvider = "data-Liters_positive")
    public void testLiters_positive(IEight eight, double in, int expected) {
        int actual = eight.liters(in);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-Liters_negative")
    public void testLiters_negative(IEight eight, double in, int expected) {
        //Assert.assertThrows(() -> eight.liters(in));
        int actual = eight.liters(in);
        Assert.assertTrue(actual == expected || actual == 0 || actual == -1);
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

    @Test(dataProvider = "data-CountPositivesSumNegatives")
    public void testCountPositivesSumNegatives(IEight eight, int[] input, int[] expected) {
        int[] actual = eight.countPositivesSumNegatives(input);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-StringToNumber")
    public void testStringToNumber(IEight eight, String input, int expected) {
        int actual = eight.stringToNumber(input);
        Assert.assertEquals(actual, expected);
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
