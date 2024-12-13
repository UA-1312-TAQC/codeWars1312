package org.academy.kata;

import org.academy.kata.dataprovider.SixDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SixTest extends SixDataProvider {

    @Test(dataProvider = "data-findNb")
    public void testFindNb(ISix six, long data, long expected, boolean positiveTest) {
        long actual = six.findNb(data);

        if(positiveTest) {
            Assert.assertEquals(actual, expected);
        } else {
            Assert.assertNotEquals(actual, expected);
        }
    }

    @Test
    public void testBalance() {
    }

    @Test
    public void testF() {
    }

    @Test(dataProvider = "data-Mean")
    public void testMean(ISix six, String town, String strng, double expected) {
        double actual = six.mean(town, strng);

        if (expected == -1) {
            Assert.assertEquals(actual, expected);
        } else {
            Assert.assertEquals(actual, expected, 1e-2,
                    "abs(actual - expected) must be <= 1e-2. Expected was " + expected + ", but got " + actual);
        }
    }

    @Test(dataProvider = "data-Variance")
    public void testVariance(ISix six, String town, String strng, double expected) {
        double actual = six.variance(town, strng);

        if (expected == -1) {
            Assert.assertEquals(actual, expected);
        } else {
            Assert.assertEquals(actual, expected, 1e-2,
                    "abs(actual - expected) must be <= 1e-2. Expected was " + expected + ", but got " + actual);
        }
    }

    @Test(dataProvider = "data-NBA")
    public void testNbaCup(ISix six, String resultSheet, String toFind, String expectedSummary) {
        String actual = six.nbaCup(resultSheet, toFind);
        Assert.assertEquals(actual, expectedSummary);
    }

    @Test (dataProvider = "data-stockSummary")
    public void testStockSummary(ISix six, String[] lstOfArt, String[] lstOf1stLetter, String expected) {
        String actual = six.stockSummary(lstOfArt, lstOf1stLetter);
        Assert.assertEquals(actual, expected);
    }
}