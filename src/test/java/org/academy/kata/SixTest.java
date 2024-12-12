package org.academy.kata;

import org.academy.kata.dataprovider.SixDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SixTest extends SixDataProvider {

    @Test
    public void testFindNb() {
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
        Assert.assertEquals(actual, expected, 1e-2);
    }

    @Test(dataProvider = "data-Variance")
    public void testVariance(ISix six, String town, String strng, double expected) {
        double actual = six.variance(town, strng);
        Assert.assertEquals(actual, expected, 1e-2);
    }

    @Test
    public void testNbaCup() {
    }

    @Test
    public void testStockSummary() {
    }
}