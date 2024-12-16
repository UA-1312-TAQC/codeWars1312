package org.academy.kata;

import org.academy.kata.dataprovider.FiveDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.academy.utils.Author;
public class FiveTest extends FiveDataProvider {
    private static IFive implementation;
    @BeforeTest
    public void setImplementation(){
        String authorName = "Boruk Daryna"; //Move to parameters
        try {
            implementation = Author.getAuthorByName(authorName).getFive();
        }catch(NullPointerException ex){
            throw new RuntimeException("The kata5 implementation for author " + authorName +
                    " not found");
        }
    }

    @Test
    public void testGap() {
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

    @Test(dataProvider = "testSmallestData")
    public void testSmallest(long in, long[] expected) {
        long[] actual = implementation.smallest(in);
        Assert.assertEquals(actual, expected);
    }
}