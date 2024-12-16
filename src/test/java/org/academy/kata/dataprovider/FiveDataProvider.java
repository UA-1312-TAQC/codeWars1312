package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FiveDataProvider extends BaseDataProvider {
    @DataProvider(name = "data-Gap")
    public static Iterator<Object[]> dpGap() {
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{2, 3, 50, new long[]{3, 5}});
        inputs.add(new Object[]{2, 100, 110, new long[]{101, 103}});
        inputs.add(new Object[]{4, 100, 110, new long[]{103, 107}});
        inputs.add(new Object[]{8, 300, 400, new long[]{359, 367}});
        inputs.add(new Object[]{10, 300, 400, new long[]{337, 347}});

        inputs.add(new Object[]{2, 3, 4, null});
        inputs.add(new Object[]{6, 100, 110, null});
        inputs.add(new Object[]{12, 300, 400, null});
        inputs.add(new Object[]{20, 500, 600, null});
        inputs.add(new Object[]{2, 2, 10, new long[]{3, 5}});

        return combineData(inputs, FIFTH);
    }
    @DataProvider(name = "data-Zeros")
    public static Iterator<Object[]> dpZeros() {
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{6,1});
        inputs.add(new Object[]{0,0});
        inputs.add(new Object[]{14,2});
        inputs.add(new Object[]{12,2});

        return combineData(inputs, FIFTH);

    }
}
