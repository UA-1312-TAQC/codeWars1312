package org.academy.kata;

import org.academy.kata.dataprovider.SevenDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SevenTest extends SevenDataProvider {

    @Test(dataProvider = "data-newAvg")
    public void testNewAvg(ISeven seven, double[] arr, double navg, long expected, boolean expectException) {
        if (!expectException) {
            long actual = seven.newAvg(arr, navg);
            Assert.assertEquals(actual, expected);
        } else {
            try {
                seven.newAvg(arr, navg);
                Assert.fail("Expected IllegalArgumentException was't thrown");
            } catch (IllegalArgumentException ex) {
                // тест проходить, якщо exception зловлено
            }
        }
    }

    @Test(dataProvider = "data-SeriesSum")
    public void testSeriesSum(ISeven seven, int n, String expected) {
        try {
            String actual = seven.seriesSum(n);
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            System.out.println(seven);
        }
        
    }
}