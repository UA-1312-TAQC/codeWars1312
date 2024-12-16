package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SevenDataProvider extends BaseDataProvider{
    @DataProvider(name = "data-newAvg")
    public static Iterator<Object[]> dpNewAvg() {
        final List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{new double[]{14, 30, 5, 7, 9, 11, 15}, 30, 149, false});
        inputs.add(new Object[]{new double[]{14, 30, 5, 7, 9, 11, 15}, 92, 645, false});
        inputs.add(new Object[]{new double[]{10}, 20, 30, false});
        inputs.add(new Object[]{new double[]{}, 50, 50, false});
        inputs.add(new Object[]{new double[]{1, 2, 3, 4, 5}, 10, 45, false});

        inputs.add(new Object[]{new double[]{14, 30, 5, 7, 9, 11, 15}, 2, 0, true});
        inputs.add(new Object[]{new double[]{100, 100, 100}, 10, 0, true});
        inputs.add(new Object[]{new double[]{50, 50, 50, 50, 50}, 20, 0, true});
        inputs.add(new Object[]{new double[]{1000}, 1, 0, true});
        inputs.add(new Object[]{new double[]{10, 20, 30, 40, 50}, 5, 0, true});

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
