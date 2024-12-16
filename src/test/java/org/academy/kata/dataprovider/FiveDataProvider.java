package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FiveDataProvider extends BaseDataProvider{

    @DataProvider(name = "smallestNumberData")
    public static Iterator<Object[]> dp() {
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{5, 2});
        inputs.add(new Object[]{55, 27});

        return combineData(inputs, EIGHTS);

    }
    @DataProvider(name = "testSmallestData")
    public Object[][] testSmallestData() {
        return new Object[][] {
                {261235, new long[]{126235L, 2, 0}},
                {209917, new long[]{29917L, 0, 1}},
                {285365, new long[]{238565L, 3, 1}},
                {269045, new long[]{26945L, 3, 0}},
                {296837, new long[]{239687L, 4, 1}},
        };
    }
}
