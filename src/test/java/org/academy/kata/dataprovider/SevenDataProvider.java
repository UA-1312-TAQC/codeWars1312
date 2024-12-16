package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SevenDataProvider extends BaseDataProvider{
    @DataProvider(name = "data-newAvg-positive")
    public static Iterator<Object[]> dpNewAvgPositive() {
        final List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{new double[]{14, 30, 5, 7, 9, 11, 15}, 30, 149});
        inputs.add(new Object[]{new double[]{14, 30, 5, 7, 9, 11, 15}, 92, 645});
        inputs.add(new Object[]{new double[]{10}, 20, 30});
        inputs.add(new Object[]{new double[]{}, 50, 50});
        inputs.add(new Object[]{new double[]{1, 2, 3, 4, 5}, 10, 45});

        return combineData(inputs, SEVENTH);
    }

    @DataProvider(name = "data-newAvg-negative")
    public static Iterator<Object[]> dpNewAvgNegative() {
        final List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{new double[]{14, 30, 5, 7, 9, 11, 15}, 2});
        inputs.add(new Object[]{new double[]{100, 100, 100}, 10});
        inputs.add(new Object[]{new double[]{50, 50, 50, 50, 50}, 20});
        inputs.add(new Object[]{new double[]{1000}, 1});
        inputs.add(new Object[]{new double[]{10, 20, 30, 40, 50}, 5});

        return combineData(inputs, SEVENTH);
    }

    @DataProvider(name = "data-SeriesSum")
    public static Iterator<Object[]> dpSeriesSum() {
        final List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{ 5, "1.57" });
        inputs.add(new Object[]{ 0, "0.00" });
        inputs.add(new Object[]{ 15, "1.94" });

        return combineData(inputs, SEVENTH);
    }
    


}
