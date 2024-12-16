package org.academy.kata;

import org.academy.kata.dataprovider.SevenDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SevenTest extends SevenDataProvider {

    @Test(dataProvider = "data-newAvg-positive")
    public void testNewAvgPositive(ISeven seven, double[] arr, double navg, long expected) {
        long actual = seven.newAvg(arr, navg);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-newAvg-negative", expectedExceptions = IllegalArgumentException.class)
    public void testNewAvgNegative(ISeven seven, double[] arr, double navg) {
        seven.newAvg(arr, navg);
    }

    @Test(dataProvider = "data-SeriesSum")
    public void testSeriesSum(ISeven seven, int n, String expected) {
        String actual = seven.seriesSum(n);
        if (actual != "") {
            Assert.assertEquals(actual, expected);
        } else {
            Assert.fail("Method" + seven + "SeriesSum must be implemented");
        }
    }
}
