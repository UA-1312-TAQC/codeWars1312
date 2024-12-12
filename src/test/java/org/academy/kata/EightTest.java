package org.academy.kata;

import org.academy.kata.dataprovider.EightDataProvider;
import org.academy.kata.implementation.nestea4.Eight;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EightTest extends EightDataProvider {


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

    @Test(dataProvider = "data-MpgToKPM")
    public void testMpgToKPM(IEight eight, float mpg, float expected) {
        float actual = eight.mpgToKPM(mpg);
        Assert.assertEquals(actual, expected, 0.001f);
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