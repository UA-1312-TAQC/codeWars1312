package org.academy.kata;

import org.academy.kata.dataprovider.FiveDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FiveTest extends FiveDataProvider {

    @Test(dataProvider = "data-Gap")
    public void testGap(IFive five, int g, long m, long n, long[] expected) {
        long[] actual = five.gap(g, m, n);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testZeros() {
    }

    @Test
    public void testPerimeter() {
    }

    @Test
    public void testSolve() {
    }

    @Test
    public void testSmallest() {
    }
}