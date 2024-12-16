package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EightDataProvider extends BaseDataProvider{

    @DataProvider(name = "data-Liters")
    public static Iterator<Object[]> dpLiters() {
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{5, 2});
        inputs.add(new Object[]{55, 27});

        return combineData(inputs, EIGHTS);

    }


    @DataProvider(name = "twoDecimalPlacesData")
    public static Iterator<Object[]> testTwoDecimalPlacesData() {
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{173735326.38, 173735326.3783732637948948, 0.00});
        inputs.add(new Object[]{14.66, 14.659725356, 0.00});
        inputs.add(new Object[]{48.92, 48.9191111131, 0.00});
        inputs.add(new Object[]{100.01, 100.009, 0.00});
        inputs.add(new Object[]{100., 100.0009, 0.00});
        inputs.add(new Object[]{100.01, 100.005, 0.00});
        return inputs.iterator();
    }
}
